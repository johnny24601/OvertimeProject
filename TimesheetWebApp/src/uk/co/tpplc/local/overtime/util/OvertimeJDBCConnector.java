package uk.co.tpplc.local.overtime.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OvertimeJDBCConnector {
	
	private static final Logger log = Logger.getLogger( OvertimeJDBCConnector.class.getName() );
	
	private static final String CLASS_DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "db.url";
	private static final String DATABASE_USERNAME = "db.username";
	private static final String DATABASE_PASSWORD = "db.password";
	
	PropertyConfigReader propertyReader;
	
	public Connection getConnection() throws SQLException {
		propertyReader = new PropertyConfigReader();
		
		try
        {
            Class.forName(CLASS_DRIVER_NAME);
        } 
        catch (ClassNotFoundException e) {
        	log.log(Level.SEVERE, e.getMessage(), e);
        }
        Connection connection = null;
        try {
            connection = DriverManager
                .getConnection(propertyReader.getPropertyValue(DATABASE_URL), propertyReader.getPropertyValue(DATABASE_USERNAME), propertyReader.getPropertyValue(DATABASE_PASSWORD));
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
        } catch (SQLException e) {
            e.printStackTrace();
            log.log(Level.SEVERE, e.getMessage(), e);
        }
	}
}
