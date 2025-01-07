package controller;

import java.io.IOException;

import dao.EmpDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet("/edit")
public class EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		int uid = Integer.parseInt(req.getParameter("uid"));
		
		EmpDao dao = new EmpDao();
		
		if(action.equals("delete")) {
			
			
			int i = dao.deleteEmp(uid);
			
			if(i>0) {
				req.setAttribute("deleteMsg", "Employee Deleted Successfully...");
				req.getRequestDispatcher("display").forward(req, resp);
			}
			
		}else if (action.equals("update")) {
			
			Employee emp = dao.getEmpById(uid);
			
			req.setAttribute("emp", emp);
			req.getRequestDispatcher("update.jsp").forward(req, resp);
			
		}
		
	}
	
}
