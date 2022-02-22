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
 * Servlet implementation class UpdateEmp
 */
@WebServlet("/update")
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
	PreparedStatement stmt;

	public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/EMPLOYEES", "root", "Khan@7867");
			stmt = con.prepareStatement("update emp1 set salary=? where id=?");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int sal = Integer.parseInt(request.getParameter("sal"));
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			stmt.setInt(1, sal);
			stmt.setInt(2, id);

			int result = stmt.executeUpdate();

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<b>" + result + " Employee Updated</b>");
			out.print("<br><a href='index.html'>Home</a><br>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	}

