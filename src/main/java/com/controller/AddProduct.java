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

@WebServlet("/addproduct")
@MultipartConfig
public class AddProduct extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int id = 0;
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));

		Part image = request.getPart("image");

		// Check if image is selected
		if (image == null || image.getSize() == 0) {
			// Alert user and return
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please select an image to upload');");
			out.println("location='adminpage.jsp';");
			out.println("</script>");
			return;
		}
        // get current time 
		String timeStamp = String.valueOf(new Date().getTime());
		String relativePath = "productImages/" + name + price + "_" + timeStamp + ".png";
      
		String imgPath = "D:\\eclipse\\EcommerceWebApp\\src\\main\\webapp\\backendImages\\";

		// combination of path 
		String fullPath = imgPath + relativePath;
		image.write(fullPath);
        
		// Call Product with passing parameter 
		Product product = new Product(id, name, price, relativePath);
		ProductDao pDao = new ProductDao();

		String message = pDao.addProduct(product);
		response.sendRedirect("/EcommerceWebApp/view/adminpage.jsp");
	}
}
