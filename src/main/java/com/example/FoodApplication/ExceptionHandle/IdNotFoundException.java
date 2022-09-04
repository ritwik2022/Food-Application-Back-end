package com.example.FoodApplication.ExceptionHandle;

public class IdNotFoundException extends RuntimeException{
	
	String message="Please Enter a valid ID";
	
	@Override
	public String getMessage() {
		return message;
	}


}
