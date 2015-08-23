package com.hand.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App 
{
	public static Connection getConnection() {
		Connection conn=null;//当前数据库连接
		try {
			Class.forName("com.mysql.jdbc.Driver");//注册驱动程序
    		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db","root","");//获取数据库连接
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void insert(String firstname,String lastname,String Email,String address) {
		Connection conn = getConnection();
		try {
			String sql = "insert into tbl_user(first_name,last_name,Email,Address)"+
						 "values('"+firstname+"','"+lastname+"','"+Email+"','"+address+"')";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("向用户表中插入了"+count+"条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
