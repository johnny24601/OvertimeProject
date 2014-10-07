package uk.co.tpplc.local.timesheet.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uk.co.tpplc.local.timesheet.service.AuthenticationService;
import uk.co.tpplc.local.timesheet.util.TimesheetJDBCConnector;

public class DefaultAuthenticationServiceImpl implements AuthenticationService {

	TimesheetJDBCConnector jdbcConnector;
	
	@Override
	public Boolean validateLogin(String userName, String password) {
		Boolean success = Boolean.FALSE;
		Connection conn = null;
		jdbcConnector = new TimesheetJDBCConnector();
		
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
			      .prepareStatement("SELECT userId, password from TIMESHEET.USER where userId = ? and password = ?");
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
