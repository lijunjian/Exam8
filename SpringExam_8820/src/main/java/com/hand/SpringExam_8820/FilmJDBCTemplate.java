package com.hand.SpringExam_8820;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

	public class FilmJDBCTemplate implements FilmDAO {

	private JdbcTemplate jdbcTemplateObject; 
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void create(String title, String description, Integer language_id) {
		String SQL = "insert into Film (title,description,language_id) values (?, ?, ?)";     
	      jdbcTemplateObject.update( SQL, title, description,language_id);
	      return;
	}
	
	public void init(){
	      System.out.println("Context Start");
	   }
	public void destroy(){
	      System.out.println("Context stop");
	   }
	

}
