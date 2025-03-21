package com.online.banking.exception;

public class CardExpiredException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CardExpiredException(String message) {
        super(message);
    }
}
