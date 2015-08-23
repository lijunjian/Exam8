package com.hand.jdbc;

import java.sql.*;

public class Query {
	
	private Query(){}
	
	public static ResultSet customerQuery(Connection conn,String name) throws Exception{
		String sql="SELECT * FROM customer WHERE first_name=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		return rs;
	}
	
	public static ResultSet CQuery(Connection conn) throws Exception{
		String sql="SELECT first_name,last_name,address.address,email,customer_id,customer.last_update from customer,address where customer.address_id=address.address_id";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		return rs;
	}
}
