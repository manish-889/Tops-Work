package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebApp", "root", "kiran@1727");

			String sql = "SELECT *FROM Reg1 WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				
				map.put("id", rs.getInt("id"));
				map.put("name", rs.getString("uname"));
				map.put("email", rs.getString("email"));
				map.put("contact", rs.getString("contact"));
				map.put("password", rs.getString("pass"));
				
				req.setAttribute("data", map);
				
				
				req.getRequestDispatcher("update.jsp").forward(req, resp);
			} else {
				System.out.println("Something went wrong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
