package com.exception;

public class NotSufficientChangeException extends RuntimeException {

	private String message;

	public NotSufficientChangeException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
