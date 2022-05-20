package com.ty.shoping.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 import static com.ty.shoping.util.AppConstants.*;
public class ConnectionObject {
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnectio()
	{
		try {
			return DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
