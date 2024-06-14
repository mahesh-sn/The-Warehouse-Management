package com.jsp.warehouse.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.warehouse.exception.AdminNotFoundByEmailException;
import com.jsp.warehouse.exception.IllegalOperationException;
import com.jsp.warehouse.exception.StorageNotFoundException;
import com.jsp.warehouse.exception.WareHouseInCityNotFoundException;
import com.jsp.warehouse.exception.WarehouseNotFoundByIdException;
import com.jsp.warehouse.exception.AddressNotFoundByIdException;

@RestControllerAdvice
public class ApplicationHandler {
	
	private static  ResponseEntity<ErrorStructure<String>> errorResponse(HttpStatus httpStatus,String rootCaause,String message){
		return ResponseEntity
				.status(httpStatus)
				.body(new ErrorStructure<String>()
						.setMessage(message)
						.setRootCause(rootCaause)
						.setStatus(httpStatus.value()));
	
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleIllegalOperationExceptio(IllegalOperationException ex){
		return errorResponse(HttpStatus.FORBIDDEN, "Alredy One supre admin exist", ex.getMessage()); 
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleUsernameNotFoundException(UsernameNotFoundException ex){
		return errorResponse(HttpStatus.NOT_FOUND, "Invalid Username given", ex.getMessage());
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleWarehouseNotFoundByIdException(WarehouseNotFoundByIdException ex){
		return errorResponse(HttpStatus.NOT_FOUND, "WareHouse with the given Id is not there", ex.getMessage());
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleAdminNotFoundByEmailException (AdminNotFoundByEmailException  ex){
		return errorResponse(HttpStatus.NOT_FOUND, "Email Invalid", ex.getMessage());
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleAddressNotFoundByIdException(AddressNotFoundByIdException ex){
		return errorResponse(HttpStatus.NOT_FOUND, "Invalid AddressId entered", ex.getMessage());
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleStorageNotFoundException(StorageNotFoundException ex){
		return errorResponse(HttpStatus.NOT_FOUND, "Storage with the given Id not found", ex.getMessage());
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleWareHouseInCityNotFoundException (WareHouseInCityNotFoundException  ex){
		return errorResponse(HttpStatus.NOT_FOUND, "Warehouse Is not there in the entered city", ex.getMessage());
	}
}














