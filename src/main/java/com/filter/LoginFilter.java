package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/view/adminpage.jsp", "/view/addproduct.jsp", "/view/editproduct.jsp", "/viewallproduct",
		"/viewalluser" })
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest) request).getSession();
		if (session.getAttribute("adminLoggedin") == null) {
			System.out.println("havenot session null");
			session.setAttribute("loginError", "Do login First!");
			((HttpServletResponse) response).sendRedirect("/EcommerceWebApp/admin.jsp");
		} else {
			System.out.println("have session , not null");
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}