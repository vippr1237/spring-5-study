package com.ifisolution.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "root";
		String pass = "root";

		try {
			System.out.println("Connect to database: " + jdbcURL);
			Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);
			System.out.println("Connection successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
