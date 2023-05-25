package com.kuebiko.it.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionUtils {
	
	private final static String URL="jdbc:mysql://localhost:3306/batch100_db";
	private final static String USERNAME="root";
	private final static String PASSWORD="mysql@1234";

	public static Connection getConnection() {
		// Loading the DRIVER
		// Class is class
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Making connect to the database
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
