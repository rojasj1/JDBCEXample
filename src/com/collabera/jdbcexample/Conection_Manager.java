package com.collabera.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection_Manager {
	static final String URL = "jdbc:mysql://localhost:3306/sakila?serverTimezone=EST5EDT";
	static final String USERNAME = "root";
	static final String PASSWORD = "justin3491";
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection was made");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public static void main(String[] args) {
		Connection conn = Conection_Manager.getConnection();
		
		//we did stuff yes
		
		
		
		try {
			conn.close();
			System.out.println("Connection was Closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

}
