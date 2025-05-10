package com.task.bank.exceptions;



public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5239873195685700014L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
