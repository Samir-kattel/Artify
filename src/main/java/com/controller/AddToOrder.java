package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/addtoorder")
public class AddToOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		String email = (String) request.getSession().getAttribute("loggedInEmail");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "");
			PreparedStatement ps = con.prepareStatement("INSERT INTO orders (id, product_id, user_email) VALUES (NULL, ?, ?)");
			ps.setInt(1, productId);
			ps.setString(2, email);
			
			int i = ps.executeUpdate();
			response.sendRedirect("view/order.jsp");
			if (i > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
