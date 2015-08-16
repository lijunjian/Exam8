package com.hand.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hand.jdbc.UserDao;
import com.hand.jdbc.User;

public class UserDaoImpl implements UserDao {
	//保存用户信息
	public void save(Connection conn, User user) throws SQLException {
		PreparedStatement ps=conn.prepareCall("Insert into film(title,description,language_id)values(?,?,?)");
		
		ps.setString(1, user.getTitle());
		ps.setString(2, user.getDescription());
		int lan=Integer.parseInt(user.getLanguage());
		ps.setInt(3,lan);
		ps.execute();
	}
	//根据用户指定的ID更新用户信息
//	public void update(Connection conn, Long id, User user) throws SQLException {
//
//		String updateSql="update tbl_user set name=?,password=?,email=? where id=?";
//		PreparedStatement ps=conn.prepareCall(updateSql);
//		
//		ps.setString(1, user.getName());
//		ps.setString(2, user.getPassword());
//		ps.setString(3,user.getEmail());
//		ps.setLong(4, id);
//		ps.execute();
//	
//	}
	//删除指定的用户信息
//	public void delete(Connection conn, User user) throws SQLException {
//		PreparedStatement ps=conn.prepareCall("delete from tbl_user where id=?");
//		
//		ps.setLong(1, user.getId());
//		ps.execute();
//	}

	public void update(Connection conn, Long id, User user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void delete(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
