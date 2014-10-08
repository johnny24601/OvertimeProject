package uk.co.tpplc.local.overtime.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uk.co.tpplc.local.overtime.service.AuthenticationService;
import uk.co.tpplc.local.overtime.util.OvertimeJDBCConnector;

public class DefaultAuthenticationServiceImpl implements AuthenticationService {

	OvertimeJDBCConnector jdbcConnector;
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	private Boolean validateUserAgainstDB(Connection conn, String userName, String password) {
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = conn
			      .prepareStatement("SELECT userEmail, password from TIMESHEET.USERS where userEmail = ? and password = ?");
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				return Boolean.TRUE;		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Boolean.FALSE;
	}

}
