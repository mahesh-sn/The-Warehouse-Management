package com.jsp.warehouse.mapper;

import org.springframework.stereotype.Component;

import com.jsp.warehouse.entity.Address;
import com.jsp.warehouse.entity.Warehouse;
import com.jsp.warehouse.requestdto.AddressRequest;
import com.jsp.warehouse.responsedto.AddressResponse;
import com.jsp.warehouse.responsedto.WarehouseAddressResponse;

@Component
public class AddressMapper {

	public Address mapToAddress(AddressRequest addressRequest,Address address) {
		address.setAddressLine(addressRequest.getAddressLine());
		address.setCity(addressRequest.getCity());
		address.setLatitude(addressRequest.getLatitude());
		address.setLongitude(addressRequest.getLongitude());
		address.setPincode(addressRequest.getPincode());
		address.setState(addressRequest.getState());
		
		return address;
	}

	public AddressResponse mapToAddressResponse(Address address) {
		return AddressResponse.builder()
				.addressLine(address.getAddressLine())
				.addressId(address.getAddressId())
				.city(address.getCity())
				.latitude(address.getLatitude())
				.longitude(address.getLongitude())
				.pincode(address.getPincode())
				.state(address.getState())
				.build();
	}
}
