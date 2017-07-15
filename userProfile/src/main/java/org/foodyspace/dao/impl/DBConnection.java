package org.foodyspace.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/foodyspace";//"jdbc:mysql://localhost:3306/heritageSchema";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "0509";//"sid@2016";
	
	public Connection getConnection() throws Exception {
		try { 
			System.out.println("connectionURL : " + CONNECTION_URL);
			Connection connection = null;
			Class.forName(DRIVER).newInstance();
			connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			return connection;
		} catch (SQLException e) {
			System.out.println("Connection can't be established : " + e.getMessage());
			throw e;
		} catch (Exception e) {
			System.out.println("Connection can't be established : " + e.getMessage());
			throw e;
		}
	}
}
