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

import com.model.Product;
import com.model.ProductDao;

@WebServlet("/updateproduct")
@MultipartConfig
public class EditProduct extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));


		Part image = request.getPart("image");
		

		String timeStamp = String.valueOf(new Date().getTime());
		String relativePath = "productImages/" + name + price + "_" + timeStamp + ".png";

		String imgPath = "D:\\eclipse\\EcommerceWebApp\\src\\main\\webapp\\backendImages\\";
		String fullPath = imgPath + relativePath;
		image.write(fullPath);
		
		Product product = new Product(id, name, price, relativePath);
		ProductDao pDao = new ProductDao();

		String message = pDao.updateProduct(product);
		response.sendRedirect("editproduct?id=" + id);
	}
}