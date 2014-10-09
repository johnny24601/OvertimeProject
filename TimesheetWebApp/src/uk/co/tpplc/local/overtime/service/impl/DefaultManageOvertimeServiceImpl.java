package uk.co.tpplc.local.overtime.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import uk.co.tpplc.local.overtime.service.ManageOvertimeService;
import uk.co.tpplc.local.overtime.util.OvertimeJDBCConnector;

public class DefaultManageOvertimeServiceImpl extends OvertimeJDBCConnector implements ManageOvertimeService {
	
	private static final Logger log = Logger.getLogger( DefaultManageOvertimeServiceImpl.class.getName() );
	
	@Override
	public Boolean writeOvertimeToDB(HttpServletRequest request) {
		Boolean success = Boolean.FALSE;
		Connection conn = null;
		
		try {
			conn = getConnection();
			writeResultSet(conn, request);
			// TODO add exception handling, must create new exception
			closeConnection(conn);
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		
		success = Boolean.TRUE;
		return success;
	}
	
	@Override
	public void readOvertimeFromDB(HttpServletRequest request) {
		Connection conn = null;
		
		try {
			conn = getConnection();
			readResultSet(conn, request);
			closeConnection(conn);
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
	}
	
	private void writeResultSet(Connection connection, HttpServletRequest request) {
		//TODO implement body to save an overtime to DB
	}

	private void readResultSet(Connection connection, HttpServletRequest request) {
		// TODO implement body to read an overtime from DB
	}
}
