package com.jsp.warehouse.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.warehouse.requestdto.WarehouseRequset;
import com.jsp.warehouse.responsedto.WarehouseResponse;
import com.jsp.warehouse.utility.ResponseStructure;

public interface WarehouseService {

	ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(WarehouseRequset warehouseRequset);

	ResponseEntity<ResponseStructure<WarehouseResponse>> findWarehouse(int warehouseId);
	
	ResponseEntity<ResponseStructure<List<WarehouseResponse>>> findAllWarehouses();

}
