package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.model.UserDao;

@WebServlet("/viewalluser")
public class ViewAllUser extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 System.out.println("view all user servlet called");
		try {
			
			UserDao udao = new UserDao();
			ArrayList<User> userList = udao.fetchAllUser();
			request.setAttribute("utList", userList);
			RequestDispatcher rd = request.getRequestDispatcher("/view/adminpage.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(); // log the error
			throw new ServletException(e);
		}

	}
}