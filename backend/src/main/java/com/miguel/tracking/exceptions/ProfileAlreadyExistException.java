package com.miguel.tracking.exceptions;

public class ProfileAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProfileAlreadyExistException() {
		super();
	}

	public ProfileAlreadyExistException(String message) {
		super(message);
	}

}//end 
