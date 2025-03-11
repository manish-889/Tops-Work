package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JavaServletContext extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String lname = req.getParameter("lname");

		ServletContext cx = getServletContext();
		String welcome = cx.getInitParameter("Hello");

		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");

		pw.write("<h1>" + welcome + "</h1>");
		pw.write("<h1>" + name + "</h1>");
		pw.write("<h1>" + lname + "</h1>");
	}
}
