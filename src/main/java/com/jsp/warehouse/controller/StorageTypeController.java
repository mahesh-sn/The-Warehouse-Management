package com.jsp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.requestdto.StorageTypeRequest;
import com.jsp.warehouse.responsedto.StorageTypeResponse;
import com.jsp.warehouse.service.StorageTypeService;
import com.jsp.warehouse.utility.ResponseStructure;

@RestController
@RequestMapping("/api/version1")
public class StorageTypeController {
	@Autowired
	private StorageTypeService storageTypeService;

	@PostMapping("/storagetypes")
	public ResponseEntity<ResponseStructure<StorageTypeResponse>> addStorageType
	(@RequestBody StorageTypeRequest storageTypeRequest){
		return storageTypeService.addStorageType(storageTypeRequest);
	}
}