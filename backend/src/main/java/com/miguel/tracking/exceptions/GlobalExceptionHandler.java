package com.miguel.tracking.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//ControllerAdvice allows you to handle exceptions across the whole app
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Could not authenticate user")
	@ExceptionHandler(AuthenticationException.class)
	public void handleAuthenticationException(AuthenticationException e) {
		log.error("User authtication failed");
		log.debug("AuthenticationException was thrown and handled", e);
	}
	
	
}//end GlobalExceptionHandler
