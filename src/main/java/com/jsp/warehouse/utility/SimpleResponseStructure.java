package com.jsp.warehouse.utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimpleResponseStructure<T> {
	private int status;
	private T message;
	public SimpleResponseStructure<T> setStatus(int status) {
		this.status = status;
		return this;
	}
	public SimpleResponseStructure<T>  setMessage(T message) {
		this.message = message;
		return this;
	}
}
