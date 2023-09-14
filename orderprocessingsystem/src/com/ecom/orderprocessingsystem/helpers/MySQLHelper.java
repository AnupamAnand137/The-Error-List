package com.ecom.orderprocessingsystem.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MySQLHelper {

	private static ResourceBundle resourceBundle;

	// singleton pattern implemented
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		resourceBundle = ResourceBundle.getBundle("resources/db");
		String userName = resourceBundle.getString("userName");
		String password = resourceBundle.getString("password");
		String url = resourceBundle.getString("url");
		String driver = resourceBundle.getString("driverClassName");
			
		//Step 1: load the driver
		Class.forName(driver);
		//internally DriverManager.registerDriver has already been called 
		
		//create the connection
		return DriverManager.getConnection(url, userName, password);

	}
}
