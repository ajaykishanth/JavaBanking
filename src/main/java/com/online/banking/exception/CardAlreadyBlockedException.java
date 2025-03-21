package com.online.banking.exception;

public class CardAlreadyBlockedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CardAlreadyBlockedException(String message) {
        super(message); 
    }
}
