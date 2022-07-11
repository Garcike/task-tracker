package com.miguel.tracking.exceptions;

public class ProfileNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProfileNotFoundException() {
		super();
	}

	public ProfileNotFoundException(String message) {
		super(message);
	}
	
}//end
