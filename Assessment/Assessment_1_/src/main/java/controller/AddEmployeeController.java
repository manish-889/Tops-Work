package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dao.EmpDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet("/AddEmployee")
public class AddEmployeeController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String mob = req.getParameter("mob");
		String address = req.getParameter("address");
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");
		String cpassword = req.getParameter("cpassword");
		
		Employee emp = new Employee(fname, lname, email, mob, address, gender, password, cpassword);
		
		EmpDao dao = new EmpDao();
		
		int i = dao.addEmp(emp);
		
		if(i > 0) {
			req.setAttribute("msg", "User Register, Now you can back to Index page...");
			req.getRequestDispatcher("addEmployee.jsp").forward(req, resp);
		}
		
	}
	
}
