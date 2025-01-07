package controller;

import java.io.IOException;
import java.util.List;

import dao.EmpDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet("/display")
public class DisplayController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmpDao dao =  new EmpDao();
		
		List<Employee> list = dao.displayAllEmployee();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("display.jsp").forward(req, resp);
		
	}
	
}
