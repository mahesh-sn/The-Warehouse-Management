package com.jsp.warehouse.exception;

public class AdminNotFoundByIdException  extends RuntimeException{
	private String message;
	public AdminNotFoundByIdException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}
}