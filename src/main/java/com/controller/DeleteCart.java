package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CartDao;

@WebServlet("/deletecart")
public class DeleteCart extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Delete cart called");
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("This is delete");
        System.out.println(id);
        CartDao cartDao = new CartDao();
        cartDao.deleteCart(id);
        response.sendRedirect("view/cart.jsp");
    }

}