package com.online.banking.exception;

public class InvalidPinException  extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPinException(String message) {
        super(message);
    }
}
