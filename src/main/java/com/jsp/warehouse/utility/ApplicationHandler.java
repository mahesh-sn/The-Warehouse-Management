package com.jsp.warehouse.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.warehouse.exception.IllegalOperationException;

@RestControllerAdvice
public class ApplicationHandler {
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleIllegalOperationExceptio(IllegalOperationException ex){
		return ResponseEntity
				.status(HttpStatus.FORBIDDEN)
				.body(new ErrorStructure<String>()
						.setMessage(ex.getMessage())
						.setRootCause("Alredy One supre admin exist")
						.setStatus(HttpStatus.FORBIDDEN.value()));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleUsernameNotFoundException(UsernameNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ErrorStructure<String>()
						.setMessage("Invalid Username given")
						.setRootCause(ex.getMessage())
						.setStatus(HttpStatus.NOT_FOUND.value()));
	}
}
