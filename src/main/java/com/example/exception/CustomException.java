package com.example.exception;

public class CustomException extends RuntimeException{

	private static final long serialVersionUID = 4704861355932020891L;
	
	public CustomException(String message) {
		super(message);
	}
	
}
