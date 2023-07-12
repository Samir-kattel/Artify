package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.model.AESEncryption;
import com.model.User;
import com.model.UserDao;

@WebServlet("/adduser")
@MultipartConfig
public class UserRegistration extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String encryptedPassword = AESEncryption.encrypt(password);

		Part image = request.getPart("profile_pic");
		HttpSession session = request.getSession();

		// Check if image is selected
		if (image == null || image.getSize() == 0) {
			// Alert user and return
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please select an image to upload');");
			out.println("location='signup.jsp';");
			out.println("</script>");
			return;
		}

		String relativePath = "userImages/" + username + ".png";
		String imgPath = "D:\\eclipse\\EcommerceWebApp\\src\\main\\webapp\\backendImages\\";
		String fullPath = imgPath + relativePath;
		image.write(fullPath);

		User user = new User(username, email, encryptedPassword, relativePath);
		UserDao uDao = new UserDao();
		String message = uDao.registerUser(user);
		session.setAttribute("registeredmessage", message);
		response.sendRedirect("index.jsp");
	}

}
