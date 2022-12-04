package com.ty.textilesmapi.exceptions;

public class InvalidCredentialException extends RuntimeException {
	String message = "Given Credentials are invalid";

	@Override
	public String getMessage() {
		return message;
	}

	public InvalidCredentialException(String message) {
		this.message = message;
	}

	public InvalidCredentialException() {

	}

}
