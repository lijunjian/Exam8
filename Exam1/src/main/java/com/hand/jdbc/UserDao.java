package com.hand.jdbc;

import java.sql.SQLException;
import java.sql.Connection;

import com.hand.jdbc.User;

public interface UserDao {

	public void save(Connection conn, User user) throws SQLException;
	
	public void update(Connection conn, Long id,User user) throws SQLException;

	public void delete(Connection conn, User user) throws SQLException;
}
