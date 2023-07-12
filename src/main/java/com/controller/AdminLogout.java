package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class AdminLogout extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // invalidate session
        request.getSession().removeAttribute("adminLoggedin");
        request.getSession().invalidate();
        
        // redirect to login page
        response.sendRedirect("admin.jsp");
    }
}