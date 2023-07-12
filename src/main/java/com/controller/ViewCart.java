package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Cart;
import com.model.CartDao;
import com.model.Product;
import com.model.ProductDao;

@WebServlet("/viewcart")
public class ViewCart extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("cart servlet called");
		try {
			// Retrieve the email from the session
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("loggedInEmail");
			CartDao cdao = new CartDao();
			ArrayList<Cart> cartList = cdao.fetchCart(email);
			System.out.println(cartList);
			request.setAttribute("cartList", cartList);
			RequestDispatcher rd = request.getRequestDispatcher("/view/cart.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(); // log the error
			throw new ServletException(e);
		}

	}
}
