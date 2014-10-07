package uk.co.tpplc.local.timesheet.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import uk.co.tpplc.local.timesheet.service.ManageTimesheetService;
import uk.co.tpplc.local.timesheet.util.TimesheetJDBCConnector;

public class DefaultManageTimesheetServiceImpl extends TimesheetJDBCConnector implements ManageTimesheetService {
	
	@Override
	public Boolean writeTimesheetToDB(HttpServletRequest request) {
		Boolean success = Boolean.FALSE;
		Connection conn = null;
		
		try {
			conn = getConnection();
			writeResultSet(conn, request);
			closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		success = Boolean.TRUE;
		return success;
	}
	
	@Override
	public void readTimesheetFromDB(HttpServletRequest request) {
		Connection conn = null;
		
		try {
			conn = getConnection();
			readResultSet(conn, request);
			closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void writeResultSet(Connection connection, HttpServletRequest request) {
		int index = 0;
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection
			      .prepareStatement("insert into TIMESHEET.USER(userId, level, password, department) values (?, ?, ?)");
			preparedStatement.setString(index++, "ppari");
			preparedStatement.setString(index++, "1");
			preparedStatement.setString(index++, "password");
			preparedStatement.setString(index++, "department");
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void readResultSet(Connection connection, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
}