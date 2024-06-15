package com.jsp.warehouse.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.entity.Address;
import com.jsp.warehouse.exception.WarehouseNotFoundByIdException;
import com.jsp.warehouse.exception.AddressNotFoundByIdException;
import com.jsp.warehouse.mapper.AddressMapper;
import com.jsp.warehouse.repo.AddressRepo;
import com.jsp.warehouse.repo.WarehouseRepo;
import com.jsp.warehouse.requestdto.AddressRequest;
import com.jsp.warehouse.responsedto.AddressResponse;
import com.jsp.warehouse.service.AddressService;
import com.jsp.warehouse.utility.ResponseStructure;

@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private WarehouseRepo warehouseRepo;
	
	
	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> saveAddress(AddressRequest addressRequest,
			int warehouseId) {
		
		return warehouseRepo.findById(warehouseId).map(warehouse->{
			Address address= addressMapper.mapToAddress(addressRequest,new Address());

			address.setWarehouse(warehouse);
			address=addressRepo.save(address);
			
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(new ResponseStructure<AddressResponse>()
							.setData(addressMapper.mapToAddressResponse(address))
							.setMessage("AddressSaved")
							.setStatus(HttpStatus.FOUND.value()));
		}).orElseThrow(()->new WarehouseNotFoundByIdException("Warehouse Invalid"));
	}


	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> findAddress(int addressId) {
		return addressRepo.findById(addressId).map(address->{
			return ResponseEntity
					.status(HttpStatus.FOUND)
					.body(new ResponseStructure<AddressResponse>()
							.setData(addressMapper.mapToAddressResponse(address))
							 .setMessage("Address Found")
							 .setStatus(HttpStatus.FOUND.value()));
		}).orElseThrow(()->new AddressNotFoundByIdException("Invalid Address"));
	}


	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(AddressRequest addressRequest,int addressId) {
		return addressRepo.findById(addressId).map(address->{
			
			address = addressMapper.mapToAddress(addressRequest, address);
			addressRepo.save(address);
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseStructure<AddressResponse>()
							.setData(addressMapper.mapToAddressResponse(address))
							.setMessage("Address Updated")
							.setStatus(HttpStatus.OK.value()));
		
		}).orElseThrow(()->new AddressNotFoundByIdException("Invalid Address"));
	}
}
