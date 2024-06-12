package com.jsp.warehouse.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WarehouseNotFoundByIdException extends RuntimeException{
	private String message;
	public String getMessage() {
		return message;
	}
}