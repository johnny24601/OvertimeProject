package uk.co.tpplc.local.overtime.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

public class OvertimeJDBCConnector {
	
	private static final Logger log = Logger.getLogger( OvertimeJDBCConnector.class.getName() );
	
	public Connection getConnection() throws SQLException {
		try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
        	log.log(Level.SEVERE, e.getMessage(), e);
        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/timesheet", "root", "root");
            System.out.println("SQL Connection to database established!");
        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
            throw new SQLException();
        }
        
        return connection;
	}
	
	public void closeConnection(Connection connection) {
		try
        {
            if(connection != null)
                connection.close();
            System.out.println("Connection closed !!");
        } catch (SQLException e) {
            e.printStackTrace();
            log.log(Level.SEVERE, e.getMessage(), e);
        }
	}
}
