package com.hand.HibernateExam_8820;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public interface CustomerDAO {
	public void setDataSource(DataSource ds);
	public void create(Integer store_id,String first_name,String last_name, String email,Integer address_id,Date create_date);
	public List<Customer> listCustomers();
	public void delete(Integer id);
	public Boolean check(Integer id);
}
