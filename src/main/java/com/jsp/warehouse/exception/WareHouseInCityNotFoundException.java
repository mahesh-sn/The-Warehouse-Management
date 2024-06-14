package com.jsp.warehouse.exception;

public class WareHouseInCityNotFoundException extends RuntimeException{
	private String message;

	public WareHouseInCityNotFoundException(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}
}
