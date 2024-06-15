package com.jsp.warehouse.requestdto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {
	@NotNull(message = "Business name cannot ben null")
	@NotEmpty(message = "Business name cannot ben null")
	private String businessName;
	@NotEmpty(message = "Email cannot be null")
	@NotNull(message = "Email cannot be empty")
	private String email;
	@NotEmpty(message = "Contact number cannot be empty")
	@NotNull(message = "Contact number cannot be null")
	private long contactNumber;
}