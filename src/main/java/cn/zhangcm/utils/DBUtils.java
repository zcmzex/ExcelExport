package cn.zhangcm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	private static final String username = "root";
	private static final String pwd = "";
	private static final String url = "jdbc:mysql://localhost:3306/exam?characterEncoding=UTF-8";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, pwd, username);
	}

}
