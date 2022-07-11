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
	
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "could not authenticate user")
	@ExceptionHandler(AuthenticationException.class)
	public void handleAuthenticationException(AuthenticationException e) {
		log.error("User authtication failed");
		log.debug("AuthenticationException was thrown and handled", e);
	}//end
	
	@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Profile already exists")
	@ExceptionHandler(ProfileAlreadyExistException.class)
	public void handleProfileAlreadyExistException(ProfileAlreadyExistException e){
		log.error("An effort to create a profile that already exists");
		log.debug("ProfileAlreadyExistException was thrown and handled", e);
	}//end
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Profile not found")
	@ExceptionHandler(ProfileNotFoundException.class)
	public void handleProfileNotFoundException(ProfileNotFoundException e){
		log.error("A profile query returned no results");
		log.debug("ProfileNotFoundException was thrown and handled", e);
	}//end
	
}//end GlobalExceptionHandler
