package com.ty.textilesmapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.textilesmapi.util.ResponseStructure;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("ID NOT FOUND");
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidCredentialException(
			InvalidCredentialException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("INVALID CREDENTIALS!");
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
}
