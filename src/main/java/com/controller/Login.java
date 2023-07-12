package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.AESEncryption;
import com.model.UserDao;

@WebServlet("/login")
public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String decryptedPassword = AESEncryption.encrypt(password);
		
		UserDao uDao = new UserDao();
		boolean isValid =  uDao.checkLogin(email, decryptedPassword);
		HttpSession session = request.getSession();
		if(isValid == true) {
			session.setAttribute("loggedInEmail",email);
			response.sendRedirect("view/home.jsp");
		}
		else {
			session.setAttribute("loginError","Invalid email or password");
			response.sendRedirect("index.jsp");		
		}
		
	}
}
