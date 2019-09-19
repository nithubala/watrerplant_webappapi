package com.revature.waterplant_webapp.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.waterplant_webapp.model.User;
import com.revature.waterplant_webapp.service.UserService;

public class UserController {

	private static UserService us = new UserService();

	public static String login(String email, String password) {

		String errorMessage = null;
        User user = null;
        
        try {
        user = us.login(email, password);
		if (user == null) {
				throw new Exception("Invalid email and Password");
			}
        }
        catch (Exception e) {
        errorMessage = e.getMessage();
		}

		String json = null;
		Gson gson = new Gson();

		if (user != null) {
			json = gson.toJson(user);
		} else if (user == null) {
			JsonObject obj = new JsonObject();
			obj.addProperty("errorMessage", errorMessage);
			json = obj.toString();
		}
		return json;

	}
	public static String adminLogin(String email, String password) {

		String errorMessage = null;
        User user = null;
        
        try {
        user = us.adminLogin(email, password);
		if (user == null) {
				throw new Exception("Invalid email and Password");
			}
        }
        catch (Exception e) {
        errorMessage = e.getMessage();
		}

		String json = null;
		Gson gson = new Gson();

		if (user != null) {
			json = gson.toJson(user);
		} else if (user == null) {
			JsonObject obj = new JsonObject();
			obj.addProperty("errorMessage", errorMessage);
			json = obj.toString();
		}
		return json;
	}

	public static String register(String name,String email,String password,String address,long mobno) {

		String message = null;
		String errorMessage = null;
		User user=null;
		try {
		    user = new User();
			user.setName(name);
			user.setEmailId(email);
			user.setPassword(password);
			user.setAddress(address);
			user.setMobileNo(mobno);

			us.register(user);
			message = "Success";
		} catch (Exception e) {
			errorMessage = e.getMessage();

		}

		JsonObject obj = new JsonObject();
		if (message != null) {

			obj.addProperty("message", message);
		} else if (errorMessage != null) {
			obj.addProperty("errorMessage", errorMessage);
		}
		return obj.toString();

	}

	public static void main(String[] args) {

		System.out.println("Test Case 1: Valid User login");
		String validUserJson = UserController.login("deep@gmail.com", "deep");
		System.out.println(validUserJson);

		System.out.println("Test Case 2: Invalid User login");
		String invalidUserJson = UserController.login("invaliduser@gmail.com", "invalidpassword");
		System.out.println(invalidUserJson);

		System.out.println("Test Case 3: Valid details");
		String ValidRegisterJson=UserController.register("sid","sid@gmail.com","Sid@1234","chetpet",9876543210l);
		System.out.println(ValidRegisterJson);
	}

}
