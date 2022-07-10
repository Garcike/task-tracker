package com.miguel.tracking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//ControllerAdvice allows you to handle exceptions across the whole app
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Could not authenticate user")
	@ExceptionHandler(AuthenticationException.class)
	public void handleAuthenticationException(AuthenticationException e) {
		//LOG.warn("Authentication exception was handled.", e);
	}
	
	
}//end GlobalExceptionHandler
