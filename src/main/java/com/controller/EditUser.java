package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.model.User;
import com.model.UserDao;

@WebServlet("/updateuser")
@MultipartConfig
public class EditUser extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("edit called user");
		System.out.println("email" + email);
		System.out.println("username" + username);
		System.out.println("password" + password);
	

		Part image = request.getPart("image");
		System.out.println("imagepath"+ image);
		
		String relativePath = "userImages/" + username + ".png";
		String imgPath = "D:\\eclipse\\EcommerceWebApp\\src\\main\\webapp\\backendImages\\";
		String fullPath = imgPath + relativePath;
		image.write(fullPath);

		
		User user = new User(username, email, password, relativePath);
		UserDao uDao = new UserDao();
		String message = uDao.updateUser(user);
		response.sendRedirect("singleuser?email=" + email);
		
	}
}