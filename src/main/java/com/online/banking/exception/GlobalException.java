package com.online.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(AccountCardAlreadyExit.class)
	public ResponseEntity<String> handleAccountCardAlreadyExit(AccountCardAlreadyExit ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT); // 409 Conflict
    }

	@ExceptionHandler(AccountInactiveException.class)
	public ResponseEntity<String> handleAccountInactiveException(AccountInactiveException ex) {
	    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST); // 400 Bad Request
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<String> handleAccountNotFoundException(AccountNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND); // 404 Not Found
    }
	
	@ExceptionHandler(CardAlreadyActiveException.class)
    public ResponseEntity<String> handleCardAlreadyActiveException(CardAlreadyActiveException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	 @ExceptionHandler(CardAlreadyBlockedException.class)
	    public ResponseEntity<String> handleCardAlreadyBlockedException(CardAlreadyBlockedException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	 
	 @ExceptionHandler(CardExpiredException.class)
	    public ResponseEntity<String> handleCardExpiredException(CardExpiredException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.GONE); // 410 Gone
	    }
	 @ExceptionHandler(CardNotFoundException.class)
	    public ResponseEntity<String> handleCardNotFoundException(CardNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	 @ExceptionHandler(InvalidPinException.class)
	    public ResponseEntity<String> handleInvalidPinException(InvalidPinException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED); // 401 Unauthorized
	    }
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleGlobalException(Exception ex) {
	        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	
}