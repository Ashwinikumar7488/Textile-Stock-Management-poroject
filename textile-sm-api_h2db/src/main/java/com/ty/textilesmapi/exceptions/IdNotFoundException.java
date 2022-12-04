package com.ty.textilesmapi.exceptions;

public class IdNotFoundException extends RuntimeException {
	private String message = "Given id not found";

	public IdNotFoundException(String message) {
		this.message = message;
	}

	public IdNotFoundException() {
	}

	@Override
	public String getMessage() {
		return message;
	}
}
