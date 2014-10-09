package uk.co.tpplc.local.overtime.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import uk.co.tpplc.local.overtime.service.AuthenticationService;
import uk.co.tpplc.local.overtime.util.OvertimeJDBCConnector;

public class DefaultAuthenticationServiceImpl implements AuthenticationService {

	private static final String SELECT_USER_QUERY = "SELECT userEmail, password from OVERTIME.USERS where userEmail = ? and password = ?";
	private static final String SELECT_ENTRIES_QUERY = "SELECT entryType from OVERTIME.ENTRY_TYPE";
	OvertimeJDBCConnector jdbcConnector;
	
	private static final Logger log = Logger.getLogger( DefaultAuthenticationServiceImpl.class.getName() );
	
	@Override
	public Boolean validateLogin(String userName, String password) {
		Boolean success = Boolean.FALSE;
		Connection conn = null;
		jdbcConnector = new OvertimeJDBCConnector();
		
		try {
			conn = jdbcConnector.getConnection();
			success = validateUserAgainstDB(conn, userName, password);
			jdbcConnector.closeConnection(conn);
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return success;
	}

	private Boolean validateUserAgainstDB(Connection conn, String userName, String password) {
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = conn
			      .prepareStatement(SELECT_USER_QUERY);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				return Boolean.TRUE;		
			}
			
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return Boolean.FALSE;
	}

	@Override
	public ArrayList<String> fetchEntryType() {
		jdbcConnector = new OvertimeJDBCConnector();
		ArrayList<String> entries = null;
		
		try {
			Connection conn = jdbcConnector.getConnection();
			entries = fetchListOfEntries(conn);
			jdbcConnector.closeConnection(conn);
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return entries;
	}

	private ArrayList<String> fetchListOfEntries(Connection conn) {
		PreparedStatement preparedStatement;
		ArrayList<String> entries = new ArrayList<String>();
		
		try {
			preparedStatement = conn
			      .prepareStatement(SELECT_ENTRIES_QUERY);
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Object result = rs.getObject(1);
				Collection<Object> resultSet = Arrays.asList(result);
				for (Object object : resultSet) {
					entries.add((String) object);
				}
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return entries;
	}
}
