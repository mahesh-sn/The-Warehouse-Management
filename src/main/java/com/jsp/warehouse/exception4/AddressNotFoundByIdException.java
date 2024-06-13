package com.jsp.warehouse.exception4;

public class AddressNotFoundByIdException extends RuntimeException{
	private String message;
	public AddressNotFoundByIdException(String message) {
		this.message=message;
}
	@Override
	public String getMessage() {
		return this.message;
	}
}
