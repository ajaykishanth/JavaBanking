package com.task.bank.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
//	private static final long serialVersionID =1l;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
