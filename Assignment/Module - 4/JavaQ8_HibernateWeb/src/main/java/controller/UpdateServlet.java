package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.Student;

import java.io.File;
import java.io.IOException;

import dao.StudentDAO;

@WebServlet("/update")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UpdateServlet extends HttpServlet {

	private static final String UPLOAD_DIR = "uploads";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("student");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Part filePart = request.getPart("photo");

		student.setName(name);
		student.setEmail(email);
		student.setPassword(password);

		if (filePart != null && filePart.getSize() > 0) {
			String fileName = filePart.getSubmittedFileName();
			String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			filePart.write(uploadPath + File.separator + fileName);
			student.setPhoto(fileName);
		}

		StudentDAO dao = new StudentDAO();
		dao.updateStudent(student);

		session.setAttribute("student", student);
		response.sendRedirect("home.jsp");
	}
}