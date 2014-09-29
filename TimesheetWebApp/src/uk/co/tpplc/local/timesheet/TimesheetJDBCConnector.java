package uk.co.tpplc.local.timesheet;

import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TimesheetJDBCConnector {
	
	public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/timesheet", "root", "root");
            System.out.println("SQL Connection to database established!");
            System.out.println("Inserting some data");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into TIMESHEET.USER values (?, ?, ?)");
            preparedStatement.setString(1, "ppari");
            preparedStatement.setString(2, "1");
            preparedStatement.setString(3, "password");
            System.out.println("Finished inserting data");
            preparedStatement.executeUpdate();
            
            System.out.println("Start reading data");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from TIMESHEET.USER");
            writeResultSet(result);
            
            preparedStatement = connection
            	      .prepareStatement("delete from TIMESHEET.USER where userid= ? ; ");
            preparedStatement.setString(1, "ppari");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            return;
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	private static void writeResultSet(ResultSet resultSet) throws SQLException {
	    while (resultSet.next()) {
	      String user = resultSet.getString("userid");
	      String level = resultSet.getString("level");
	      String password = resultSet.getString("password");
	      System.out.println("User: " + user);
	      System.out.println("Level: " + level);
	      System.out.println("password: " + password);
	    }
	  }
}
