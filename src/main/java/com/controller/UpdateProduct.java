package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Product;
import com.model.ProductDao;


@WebServlet("/editproduct")
public class UpdateProduct extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("editproduct called");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Product pt = new ProductDao().getProductById(id);
		System.out.println(pt);
		request.setAttribute("product",pt);
		RequestDispatcher rd = request.getRequestDispatcher("view/editproduct.jsp");
		rd.forward(request, response);
	}
}