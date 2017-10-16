package cn.zhangcm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
	private static String url = "jdbc:mysql://localhost:3306/exam"
			+ "?useUnicode=true&characterEncoding=utf-8";
	private static String userName = "root";
	private static String password = "123";
	static {
		// 注册mysql jdbc driver
		try {
			com.mysql.jdbc.Driver.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {

		Connection conn = DriverManager.getConnection(url, userName, password);
		conn.setAutoCommit(true);
		return conn;
	}

	public static int getGeneratedInt(Statement stmt) throws SQLException {
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		return rs.getInt(1);

	}

}
