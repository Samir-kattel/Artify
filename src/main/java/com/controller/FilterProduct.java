package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Product;
import com.model.ProductDao;

@WebServlet("/filterproduct")
public class FilterProduct extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 System.out.println("ViewAllProduct servlet called");
		try {
			
			ProductDao pdao = new ProductDao();
			ArrayList<Product> productList = pdao.fetchProductLowHigh();
			request.setAttribute("filteredProductList", productList);
			RequestDispatcher rd = request.getRequestDispatcher("/view/product.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(); // log the error
			throw new ServletException(e);
		}

	}
}