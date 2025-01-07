package controller;

import java.io.IOException;

import dao.EmpDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet("/UpdateEmplaoyee")
public class UpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String mob = req.getParameter("mob");
		
		Employee emp = new Employee();
		emp.setId(id);
		emp.setFname(fname);
		emp.setLname(lname);
		emp.setEmail(email);
		emp.setMob(mob);
		
		EmpDao dao = new EmpDao();
		
		int i = dao.updateEmployeeDetails(emp);
		
		if(i>0) {
			req.setAttribute("updatemsg", "Employee Details Updated Successfully...");
			req.getRequestDispatcher("display").forward(req, resp);
		}
		
	}
	
}
