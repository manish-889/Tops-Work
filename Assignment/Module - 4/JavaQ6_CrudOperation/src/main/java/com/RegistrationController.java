package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("uname");
		String email=req.getParameter("email");
		String contact=req.getParameter("contact");
		String pass=req.getParameter("password");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/WebApp","root","kiran@1727");
			PreparedStatement ps=con.prepareStatement("insert into Reg1 values(?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, contact);
			ps.setString(5, pass);
			
			int i=ps.executeUpdate();
			if(i>0) {
				req.setAttribute("msg", "Student Add Succesfully....");
				req.getRequestDispatcher("Index.jsp").forward(req, resp);
			}else {
				req.setAttribute("error", "Invalid....");
				req.getRequestDispatcher("Index.jsp").forward(req, resp);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
