package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.jdbc.ConnectionFactory;
import com.hand.jdbc.UserDao;
import com.hand.jdbc.UserDaoImpl;
import com.hand.jdbc.User;

/**
 * Servlet implementation class InsertServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		Connection conn=null;
		try {
			
			conn=ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			UserDao userDao=new UserDaoImpl();
			User tom=new User();
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String language = request.getParameter("language");
			tom.setTitle(title);
			tom.setDescription(description);
			tom.setLanguage(language);
			
			userDao.save(conn, tom);
			conn.commit();
			
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally{
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		
	}

}
