package com.nadeem.addEmp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateEmp
 */
@WebServlet("/create")
public class CreateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection conn;
	PreparedStatement stmt;
  
	public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/EMPLOYEES", "root", "Khan@7867");
			stmt = conn.prepareStatement("insert into emp1 values(?,?,?,?,?)");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int sal = Integer.parseInt(request.getParameter("sal"));
		String desig = request.getParameter("desig");

		try {
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setInt(3, age);
			stmt.setInt(4, sal);
			stmt.setString(5, desig);
			stmt.executeUpdate();
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.print("<b>"+name+"  Added</b>");
			out.print("<br><a href='index.html'>Home</a><br>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	catch (NullPointerException e) {
		e.printStackTrace();
	}
	}
	public void destroy() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
