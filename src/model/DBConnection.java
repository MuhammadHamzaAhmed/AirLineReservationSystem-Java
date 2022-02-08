package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection con;
	private static final String URL = "jdbc:sqlite:AirLineReservationSystem.db"; //url

	private DBConnection() {
	}

	public static Connection getConnection() {
		if (con == null)
			initializeConnection();				//initializing connection
		return con;
	}

	private static void initializeConnection() {
		try {
			con = DriverManager.getConnection(URL);		// getting connection from driver
		} catch (Exception e) {
			e.printStackTrace();											// print exception
			System.exit(1);				//Exiting system
		}
	}
	public static void main(String[] args) {
		getConnection();
		System.out.println("Connected");
	}
}
