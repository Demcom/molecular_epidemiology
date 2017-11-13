package db_connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import models.PacientModel;

public class DataBaseConnection {
	
	private DataBaseConnection() {}
	
	private final String dbms = "mysql"; 
	private final String jdbc = "jdbc";
	private final String userName = "root";
	private final String password = "root";
	private final String serverName = "localhost";
	private final String portNumber = "3306";
		
	private static DataBaseConnection dbConnection = new DataBaseConnection();
	
	public static DataBaseConnection getInstance() {
		return dbConnection;
	}
	
	public void getPacientInfo(int id) {
		try {
			Connection conn = getConnection();
			System.out.println("connection opened");
			
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<PacientModel> getPacients() {
		try {
			Connection conn = getConnection();
			System.out.println("connection opened");
			String sql = "SELECT nombre, apellido, eua_cruzado, deportado, cambiar_ciudad, drogas, eua_legal FROM paciente";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<PacientModel> pacientModels = new ArrayList<>();
		    while(rs.next()){
		    	PacientModel pacient = new PacientModel();
		    	pacient.name = rs.getString("nombre");
		    	pacient.lastName = rs.getString("apellido");
		    	pacient.eua_cruzado = rs.getString("eua_cruzado");
		    	pacient.deportado = rs.getString("deportado");
		    	pacient.cambiar_ciudad = rs.getString("cambiar_ciudad");
		    	pacient.drogas = rs.getString("drogas");
		    	pacient.eua_legal = rs.getString("eua_legal");
		    	pacientModels.add(pacient);
		    }
		    rs.close();
			conn.close();
			return pacientModels;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
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
