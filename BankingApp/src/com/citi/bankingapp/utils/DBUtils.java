package com.citi.bankingapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// DB related functionalities we will hold it in this class.
// how many object we can expect? only one object ? 

// we should follow singleton DP. 
// DP : common solutions to common problems.
// one object : singleton object 

public class DBUtils {
	
	private static final String DB_URL="jdbc:mysql://localhost:3306/citi";
	private static final String DB_USERNAME="root";
	private static final String DB_PASSWORD="root";
	// private : 
	// static : only one copy
	// final : not to change the value.
	// String
	
	private static DBUtils dbUtils;
	// static private ref : only one copy.
	
	public static DBUtils getInstance() {
		// getInstance : get the object.
		// only one object will be created.
		if(dbUtils == null) {
			System.out.println("object created");
			dbUtils =  new DBUtils();
			return dbUtils;
		}
		else {
			System.out.println("ref shared");
			return dbUtils;}
	}
	
	private DBUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection	() {
		// it should return the connection object which will help us to perform some DB related work.
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	
	public void closeConnection(Connection connection) {
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
