package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public FilmServlet() throws ServletException, IOException{
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		doPost(request,response);
	};

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sql="SELECT film.film_id,film.title,description,language.name FROM film,language where film.language_id=language.language_id"; 
		Connection conn=null;//当前数据库连接
    	Statement st=null;//用于向数据库发送数据
    	ResultSet rs=null;//结果集，封装了从数据库查询到的数据 
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");//注册驱动程序
    		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","");//获取数据库连接
    		st=conn.createStatement();
    		rs=st.executeQuery(sql);
    		int id[]=new int[1000];
    		int i = 0,j = 0;
    		String film[]=new String[3000];
    		
    		while(rs.next()){
    			System.out.print(rs.getInt("film_id")+" ");
    			id[i]=rs.getInt("film_id");i++;
    			System.out.print(rs.getString("title")+" ");
    			film[j]=rs.getString("title");j++;
    			System.out.print(rs.getString("description")+" ");
    			film[j]=rs.getString("description");j++;
    			System.out.print(rs.getString("name")+" ");
    			film[j]=rs.getString("name");j++;
    			System.out.println();
    		}
    		
//    		RequestDispatcher rd=request.getRequestDispatcher("/showfilm.jsp");
//    		rd.forward(request, response);
    		
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (Exception e2) {
			}
			try {
				st.close();
			} catch (Exception e3) {
			}
			try {
				conn.close();
			} catch (Exception e4) {
			}
		}
	}
}
