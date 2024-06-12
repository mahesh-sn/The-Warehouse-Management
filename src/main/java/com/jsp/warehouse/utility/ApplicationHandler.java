package com.jsp.warehouse.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.warehouse.exception.AdminNotFoundByEmailException;
import com.jsp.warehouse.exception.IllegalOperationException;
import com.jsp.warehouse.exception.WarehouseNotFoundByIdException;

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
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleWarehouseNotFoundByIdException(WarehouseNotFoundByIdException ex){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ErrorStructure<String>()
						.setMessage(ex.getMessage())
						.setRootCause("WareHouse with the given Id is not there")
						.setStatus(HttpStatus.NOT_FOUND.value()));
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleAdminNotFoundByEmailException (AdminNotFoundByEmailException  ex){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ErrorStructure<String>()
						.setMessage(ex.getMessage())
						.setRootCause("Email Invalid")
						.setStatus(HttpStatus.NOT_FOUND.value()));
	}
	
	
	
	
}