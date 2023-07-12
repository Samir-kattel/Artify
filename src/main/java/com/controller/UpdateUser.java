package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.model.UserDao;


@WebServlet("/edituser")
public class UpdateUser extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("edit user called");
		String email = request.getParameter("email");
		System.out.println(email);
		User ut = new UserDao().getUserById(email);
		System.out.println(ut);
		request.setAttribute("user",ut);
		RequestDispatcher rd = request.getRequestDispatcher("view/editprofile.jsp");
		rd.forward(request, response);
	}
}