package com.jsp.warehouse.responsedto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WarehouseAddressResponse {
	private int warehouseId;
	private String warehouseName;
	private int addressId;
	private String addressLine;
	private String city;
	private String state;
	private int pincode;
	private String longitude;
	private String latitude;
}