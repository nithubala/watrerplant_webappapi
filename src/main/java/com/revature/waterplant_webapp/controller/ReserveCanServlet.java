package com.revature.waterplant_webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.waterplant_webapp.model.Reserve;


public class ReserveCanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Reserve reserve=null;
		
		String reservecans=request.getParameter("reservecans");
		int reservedcans=Integer.parseInt(reservecans);
		
		reserve=new Reserve();
		
		String userid=request.getParameter("userId");
		int userId=Integer.parseInt(userid);
		reserve.setUserId(userId);
		reserve.setName(request.getParameter("name"));
	    String mobileno=request.getParameter("mobileNo");
		long mobileNo=Long.parseLong(mobileno);
		reserve.setMobileNo(mobileNo);
		
		System.out.println(reserve);
		
		 String Json=ReserveController.reserveCans(reserve,reservedcans);
		 PrintWriter out = response.getWriter();
	     out.write(Json);
	     out.flush();
		
		
	}

	

}
