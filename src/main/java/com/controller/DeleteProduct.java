package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.ProductDao;

@WebServlet("/deleteproduct")
public class DeleteProduct extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        System.out.println("This is delete");
        System.out.println(productId);
        ProductDao productDao = new ProductDao();
        productDao.deleteProduct(productId);
        response.sendRedirect("view/adminpage.jsp");
    }

}