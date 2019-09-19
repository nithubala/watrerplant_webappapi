package com.revature.waterplant_webapp.controller;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.waterplant_webapp.exception.ServiceException;
import com.revature.waterplant_webapp.model.Stock;
import com.revature.waterplant_webapp.service.AdminService;

public class StockController {
	
	private static AdminService as = new AdminService();

	public static String updateStock(int addCans) {
		
		String message=null;
		String errorMessage = null;
		
		try {
			if(addCans>0) {
			as.updateStock(addCans);
			message="Sucess";}
			else {
				throw new Exception("Please enter valid number of cans");
				}
		} catch (Exception e) {
			
			errorMessage=e.getMessage();
		}
		
		JsonObject obj = new JsonObject();
		if (message != null) {

			obj.addProperty("message", message);
		} else if (errorMessage != null) {
			obj.addProperty("errorMessage", errorMessage);
		}
		return obj.toString();

		
	}
	
	public static String viewStock() {
		
	    List<Stock> list=null;
		try {
			list=as.viewstock();
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		   Gson gson = new Gson();
		   String json = gson.toJson(list);
		   return json;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Test Case 1: Valid Stock Update");
		String validStockJson = StockController.updateStock(500);
		System.out.println(validStockJson);

		
		
	}
}
