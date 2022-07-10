package com.miguel.tracking.exceptions;

public class AuthenticationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AuthenticationException() {
		super();
	}

	public AuthenticationException(String message) {
		super(message);
	}
	
}//end class
