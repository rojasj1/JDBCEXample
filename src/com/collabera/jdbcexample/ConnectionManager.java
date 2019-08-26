package com.collabera.jdbcexample;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	static final String URL = "jdbc:mysql://localhost:3306/sakila?serverTimezone=EST5EDT";
	static final String USERNAME = "root";
	static final String PASSWORD = "justin3491";
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection was made");
			
			//Creating a statement
			 Statement stmt = conn.createStatement(
	                    ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY);
	            
	            String query = "SELECT * FROM customer";
	              ResultSet rs = stmt.executeQuery(query);
	              
	              while(rs.next()) {
	                  String fn = rs.getString("first_name");
	                  String ln = rs.getString("last_name");
	                  int id = rs.getInt("store_id");
	                  int ID = rs.getInt("customer_id");
	                  
	                  System.out.println( "Customer ID:"+ID+" " +"Store ID:" +id+" \n"+fn+ " "+ ln);
	              }
//			 PreparedStatement pstmt = conn.prepareStatement(
//	                    "select * from sakila.actor where first_name = ?");
//	            
//	            pstmt.setString(1, "We have found a first name");
//	            
//	            ResultSet rs = pstmt.executeQuery();
//	            while(rs.next()) {
//	                System.out.println(rs.getString("first_name"));
//	            }
//	            pstmt.setString(1, "We found a first name");
//	            
//	            ResultSet rs1 = pstmt.executeQuery();
//	            while(rs1.next()) {
//	                System.out.println(rs1.getString("first_name"));
//	            }
	              stmt.close();
	                System.out.println("statement was closed.");
	            conn.close();
	            System.out.println("connection was closed.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	
		return conn;
	}
	
	
	
	public static void main(String[] args) {
		Connection conn = ConnectionManager.getConnection();
		
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
