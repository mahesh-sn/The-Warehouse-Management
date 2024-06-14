package com.jsp.warehouse.exception;

public class StorageNotFoundException extends RuntimeException {
	private String message;

	public StorageNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}