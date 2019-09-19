package com.revature.waterplant_webapp.controller;

import com.google.gson.JsonObject;
import com.revature.waterplant_webapp.model.Order;
import com.revature.waterplant_webapp.service.UserService;

public class OrderController {
	
	private static UserService us=new UserService();
	
	public static String orderCans(Order order, int orderedCans) {
		
		String message=null;
		String errorMessage=null; 
		
		try {
			if(orderedCans>0) {
			us.orderCans(order,orderedCans);
			message="Success";}
			else {
				throw new Exception("Please enter valid number of cans");
			}
		} catch (Exception e) {
			
			errorMessage=e.getMessage();
		}
		
		JsonObject obj=new JsonObject();
		if(message!=null) {
			obj.addProperty("message", message);
			
		}
		else if(errorMessage!=null) {
			obj.addProperty("errorMessage", errorMessage);
		}
		return obj.toString();
		
	}

	public static void main(String[] args) {

	}


}
