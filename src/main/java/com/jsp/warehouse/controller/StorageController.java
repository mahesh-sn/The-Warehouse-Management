package com.jsp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.entity.Storage;
import com.jsp.warehouse.requestdto.StorageRequest;
import com.jsp.warehouse.responsedto.StorageResponse;
import com.jsp.warehouse.service.StorageService;
import com.jsp.warehouse.utility.ResponseStructure;
import com.jsp.warehouse.utility.SimpleResponseStructure;

@RestController
@RequestMapping("/api/version1")
public class StorageController {
	@Autowired
	private StorageService storageService;
	
	@PostMapping("/warehouses/{warehouseId}/storages")
	public ResponseEntity<SimpleResponseStructure<String>> addStorage(@RequestBody StorageRequest stroageRequest,@PathVariable int warehouseId,@RequestParam("no_of_storage_units") int noOfStorageUnits){
		return storageService.addStorage(stroageRequest,warehouseId,noOfStorageUnits);
	}
	@PutMapping("/storages/{storageId}")
	public ResponseEntity<ResponseStructure<StorageResponse>>  updateStorage(@RequestBody StorageRequest storageRequest,@PathVariable int storageId){
		return storageService.updateStorage(storageRequest,storageId);
	}
}