package com.online.banking.exception;

public  class AccountCardAlreadyExit extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AccountCardAlreadyExit(String message) {
		super(message);
	}
}
