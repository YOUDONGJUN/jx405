package com.example.exception;

public class MovieTicketingErrorException extends CustomException{

	private static final long serialVersionUID = 1168913749431615650L;

	public MovieTicketingErrorException(String message) {
		super(message);
	}

}
