package com.jsp.warehouse.exception;

public class AdminNotFoundByEmailException extends RuntimeException{
	private String message;
	public AdminNotFoundByEmailException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}
}