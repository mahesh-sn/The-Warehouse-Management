package com.jsp.warehouse.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.requestdto.WarehouseRequset;
import com.jsp.warehouse.responsedto.WarehouseResponse;
import com.jsp.warehouse.service.WarehouseService;
import com.jsp.warehouse.utility.ResponseStructure;

@RestController
@RequestMapping("/api/version1")
public class WarehouseController {
	@Autowired
	private WarehouseService warehouseService;

	@PreAuthorize("hasAuthority('CREATE_WAREHOUSE')")
	@PostMapping("/warehouses")
	public ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(@RequestBody WarehouseRequset warehouseRequset) {
		return warehouseService.createWarehouse(warehouseRequset);
	}
	
	@GetMapping("/warehouses/{warehouseId}")
	public ResponseEntity<ResponseStructure<WarehouseResponse>> findWarehouse(@PathVariable int warehouseId) {
		return warehouseService.findWarehouse(warehouseId);
	}
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<WarehouseResponse>>> findAllWarehouses(){
		return warehouseService.findAllWarehouses();
	}
	
}