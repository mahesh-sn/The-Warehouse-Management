package com.jsp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.requestdto.AddressRequest;
import com.jsp.warehouse.responsedto.AddressResponse;
import com.jsp.warehouse.service.AddressService;
import com.jsp.warehouse.utility.ResponseStructure;

@RestController
@RequestMapping("/api/version1")
public class AddressController {
	@Autowired
	private AddressService addressService;

	@PostMapping("warehouses/{warehouseId}/addresses")
	public ResponseEntity<ResponseStructure<AddressResponse>> saveAddress
	(@RequestBody AddressRequest addressRequest,@PathVariable int warehouseId){
		return addressService.saveAddress(addressRequest,warehouseId);
	}

	@GetMapping("addresses/{addressId}")
	public ResponseEntity<ResponseStructure<AddressResponse>> findAddress(@PathVariable int addressId){
		return addressService.findAddress(addressId);
	}

	@PutMapping("addresses/{addressId}")
	public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress
	(@RequestBody AddressRequest addressRequest,@PathVariable int addressId){
		return addressService.updateAddress(addressRequest,addressId);
	}
}





