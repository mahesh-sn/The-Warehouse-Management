package com.jsp.warehouse.service;

import org.springframework.http.ResponseEntity;

import com.jsp.warehouse.requestdto.StorageRequest;
import com.jsp.warehouse.utility.SimpleResponseStructure;

public interface StorageService {


	ResponseEntity<SimpleResponseStructure<String>> addStorage(StorageRequest storageRequest, int warehouseId,
			int noOfStorageUnits);

}
