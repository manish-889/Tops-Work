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

@WebServlet("/update")
public class UpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int uid = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("uname");
		String email = req.getParameter("email");
		String contact = req.getParameter("contact");
		String password = req.getParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebApp", "root", "kiran@1727");
			PreparedStatement ps = con
					.prepareStatement("update Reg1 set uname = ?, email = ?, contact = ?, pass = ? where id= ?");
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, contact);
			ps.setString(4, password);
			ps.setInt(5, uid);

			int i = ps.executeUpdate();
			if (i > 0) {
				req.setAttribute("msg", "Student Update Succesfully....");
				req.getRequestDispatcher("Index.jsp").forward(req, resp);
			} else {
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
