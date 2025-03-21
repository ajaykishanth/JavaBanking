package com.online.banking.exception;

public class CardAlreadyActiveException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CardAlreadyActiveException(String message) {
        super(message);
    }
}
