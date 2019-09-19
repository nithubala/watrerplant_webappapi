package com.revature.waterplant_webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.waterplant_webapp.exception.ServiceException;
import com.revature.waterplant_webapp.model.Stock;
import com.revature.waterplant_webapp.service.AdminService;

public class ViewStockServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	       String Json=StockController.viewStock();
		   PrintWriter out = response.getWriter();
		   out.println(Json);
		   out.flush();
	 }
	
	}


