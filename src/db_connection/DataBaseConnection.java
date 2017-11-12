package db_connection;

import java.sql.*;
import java.util.Properties;

public class DataBaseConnection {
	
	private DataBaseConnection() {}
	
	private final String dbms = "mysql"; 
	private final String jdbc = "jdbc";
	private final String userName = "your_password";
	private final String password = "your_password";
	private final String serverName = "localhost";
	private final String portNumber = "3306";
		
	private static DataBaseConnection dbConnection = new DataBaseConnection();
	
	public static DataBaseConnection getInstance() {
		return dbConnection;
	}
	
	public void getPacientInfo() {
		try {
			Connection conn = getConnection();
			System.out.println("connection opened");
			
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void printTableNames(Connection conn) {
		try {
			DatabaseMetaData md = conn.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			while (rs.next()) {
			  System.out.println(rs.getString(3));
			}
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private Connection getConnection() throws SQLException {
	    String fullDbConnection = jdbc + ":" + dbms + "://" + serverName + ":" + portNumber + "/"+"development";
	    return DriverManager.getConnection(fullDbConnection, userName, password);
	}

}
