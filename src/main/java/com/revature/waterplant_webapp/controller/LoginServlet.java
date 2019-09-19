package com.revature.waterplant_webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
	    String json= UserController.login(email, password);
       
        HttpSession session = request.getSession();
		session.setAttribute("LOGGED_IN_USER", json);
	
        PrintWriter out = response.getWriter();
        out.write(json);
        out.flush();	
	}

}
