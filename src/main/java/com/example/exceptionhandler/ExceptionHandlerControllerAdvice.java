package com.example.exceptionhandler;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.ResponseDto;
import com.example.exception.CustomException;
import com.example.exception.ErrorException;
import com.example.exception.MovieTicketingErrorException;
import com.example.exception.ReviewErrorException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(CustomException.class)
	public String handlerCustomException(CustomException e) {
		return "error/customError";
	}
	@ExceptionHandler(DataAccessException.class)
	public String handlerDataAccessException(DataAccessException e) {
		return "error/databaseError";
	}
	@ExceptionHandler(Exception.class)
	public String handlerException(Exception e) {
		return "error/serverError";
	}
	
	@ExceptionHandler(ErrorException.class)
	public @ResponseBody ResponseDto<?> errorExceptionHandler(ErrorException e) { 
		ResponseDto<?> response = new ResponseDto<>();
		
		response.setStatus(false);
		response.setError(e.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(MovieTicketingErrorException.class)
	public @ResponseBody ResponseDto<?> handlerMovieException(MovieTicketingErrorException e) {
		e.printStackTrace();
		ResponseDto<?> response = new ResponseDto<>();
		response.setStatus(false);
		response.setError(e.getMessage());
		return response;
	}

	
	@ExceptionHandler(ReviewErrorException.class)
	public @ResponseBody ResponseDto<?> ReviewExceptionHandler(ReviewErrorException e) {
		ResponseDto<?> response = new ResponseDto<>();
		
		response.setStatus(false);
		response.setError(e.getMessage());
		
		return response;
	}
}
