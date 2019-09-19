package com.revature.waterplant_webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String noOfCans=request.getParameter("addedCans");
		int addCans=Integer.parseInt(noOfCans);
		
		String json=StockController.updateStock(addCans);
		PrintWriter out = response.getWriter();
        out.write(json);
        out.flush();	
			
	}

	
}
