package com.hand.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import com.opensymphony.xwork2.ActionSupport;

public class Add extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	
	public String execute(){
		
		String s = null;
		int addressid = -1;
		try {
        	Connection conn = null;
    		String URL = "jdbc:mysql://localhost:3306/sakila";        	
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(URL, "root", "");
	        
	        String sql = "SELECT address_id FROM address WHERE address = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, address);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
		          addressid = rs.getInt(1);
		        }
	        
	        
	        String sql1 = "INSERT INTO customer(store_id,first_name,last_name,email,address_id,create_date)";
	        sql1+="VALUES(1,?,?,?,?,?)";
	        PreparedStatement ps1 = conn.prepareStatement(sql1);
	        ps1.setString(1, firstName);
	        ps1.setString(2, lastName);
	        ps1.setString(3, email);
	        ps1.setInt(4,addressid);
	        java.util.Date utilDate=new Date();
	        ps1.setDate(5, new java.sql.Date(utilDate.getTime()));
	        int rs1 = ps1.executeUpdate();
	        while (rs1 == 1) {
	           s = "success";
	        }   
		} catch (Exception e) {
			e.printStackTrace();
			s = "false";
		}	
		return s;
	
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	

}
