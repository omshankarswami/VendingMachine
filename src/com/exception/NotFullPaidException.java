package com.exception;

public class NotFullPaidException extends RuntimeException {

	private String message;
	private long remaining;

	public NotFullPaidException(String message, long remaining) {
		super();
		this.message = message;
		this.remaining = remaining;
	}

	public String getMessage() {
		return message;
	}

	public long getRemaining() {
		return remaining;
	}

}
