package com.revature.waterplant_webapp.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.waterplant_webapp.model.Reserve;
import com.revature.waterplant_webapp.service.UserService;

public class ReserveController {
private static UserService us=new UserService();
	
public static String reserveCans(Reserve reserve, int reservedcans) {
	String errorMessage=null; 
		
		try {
			if(reservedcans>0) {
			reserve=us.reserveCans(reserve,reservedcans);
			
			}
			else {
				throw new Exception("Please enter valid number of cans");
			}
		} catch (Exception e) {
			
			errorMessage=e.getMessage();
		}
		
		String json = null;
		Gson gson = new Gson();
		
		if (reserve != null) {
			json = gson.toJson(reserve);
		} else if (reserve == null) {
			JsonObject obj = new JsonObject();
			obj.addProperty("errorMessage", errorMessage);
			json = obj.toString();
		}
		return json;
	}

}
