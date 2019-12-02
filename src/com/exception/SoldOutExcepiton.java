package com.exception;

public class SoldOutExcepiton extends RuntimeException {

	private String message;

	public SoldOutExcepiton(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
