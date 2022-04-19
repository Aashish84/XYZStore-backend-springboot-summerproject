package com.asish.ecom.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler{
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public Map<String,String> exceptionHandler(Exception  ex) {
		Map<String,String> ob = new HashMap<>();
		ob.put("status", "exception occured");
		ob.put("exception", ex.getClass().getName());
		ob.put("message", ex.getMessage());
		return ob;
	}
	
}
