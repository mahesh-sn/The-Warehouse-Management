package com.jsp.warehouse.requestdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
	private String addressLine;
	private String city;
	private String state;
	private int pincode;
	private String longitude;
	private String latitude;
}
