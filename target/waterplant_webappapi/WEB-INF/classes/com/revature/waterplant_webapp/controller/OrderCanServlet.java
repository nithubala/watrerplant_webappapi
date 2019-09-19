package com.revature.waterplant_webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.revature.waterplant_webapp.model.Order;




public class OrderCanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order = null;
		
		String orderCans=request.getParameter("ordercans");
		int orderedCans=Integer.parseInt(orderCans);
		
		//System.out.println(session.getAttribute("LOGGED_IN_USER"));
		
		order =new Order();
		String userid=request.getParameter("userId");
		int userId=Integer.parseInt(userid);
		order.setUserId(userId);
		order.setName(request.getParameter("name"));
		order.setAddress(request.getParameter("address"));
		String mobileno=request.getParameter("mobileNo");
		long mobileNo=Long.parseLong(mobileno);
		order.setMobileNo(mobileNo);
		
		System.out.println(order);
			
		 String Json=OrderController.orderCans(order,orderedCans);
		 PrintWriter out = response.getWriter();
	     out.write(Json);
	     out.flush();
		
		
		
	}

}
