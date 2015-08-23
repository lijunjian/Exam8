package com.hand.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySQLConnection {

	private MySQLConnection() {
	}

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");// 注册驱动程序
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "");// 获取数据库连接
		return conn;
	}
}
