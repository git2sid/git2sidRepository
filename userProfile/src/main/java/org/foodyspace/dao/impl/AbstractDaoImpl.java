package org.foodyspace.dao.impl;

import java.sql.Connection;

public abstract class AbstractDaoImpl {
	public Connection getConnection() {
		DBConnection database= new DBConnection();
		Connection connection = null;
		try {
			connection = database.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
