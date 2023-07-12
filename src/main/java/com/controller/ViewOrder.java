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

import com.model.Orders;
import com.model.OrdersDao;


@WebServlet("/vieworder")
public class ViewOrder extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("order servlet called");
		try {
			// Retrieve the email from the session
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("loggedInEmail");
			OrdersDao odao = new OrdersDao();
			ArrayList<Orders> orderList = odao.fetchOrders(email);
			System.out.println(orderList);
			request.setAttribute("orderList", orderList);
			RequestDispatcher rd = request.getRequestDispatcher("/view/order.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(); // log the error
			throw new ServletException(e);
		}

	}
}
