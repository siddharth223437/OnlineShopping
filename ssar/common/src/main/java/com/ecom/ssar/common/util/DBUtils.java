package com.ecom.ssar.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtils {
	
	public static final String DATABASE_USER = "user";

	public static final String DATABASE_PASSWORD = "password";

	public static final String MYSQL_AUTO_RECONNECT = "autoReconnect";

	public static final String MYSQL_MAX_RECONNECTS = "maxReconnects";

	public static Connection getConnection() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		// load the driver
		Class.forName(driver);
		String dbURL = "jdbc:mysql://localhost/OnlineShop";
		String dbUsername = "root";
		String dbPassword = "root";

		java.util.Properties connProperties = new java.util.Properties();
		connProperties.put(DATABASE_USER, dbUsername);
		connProperties.put(DATABASE_PASSWORD, dbPassword);
		connProperties.put(MYSQL_AUTO_RECONNECT, "true");
		connProperties.put(MYSQL_MAX_RECONNECTS, "4");
		Connection conn = DriverManager.getConnection(dbURL, connProperties);
		return conn;
	}
	
	public static void closeResource(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (con != null) {
				con.close();
			}
			if (ps != null) {
				ps.close();
				ps.clearBatch();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static PreparedStatement createRSConnection(String SQL) {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = getConnection();
			ps = (PreparedStatement) con.prepareStatement(SQL);
		} catch (Exception e) {
			System.out.println(e);
		}
		return ps;
	}

}
