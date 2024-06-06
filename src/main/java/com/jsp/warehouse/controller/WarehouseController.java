package com.jsp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.warehouse.requestdto.WarehouseRequset;
import com.jsp.warehouse.responsedto.WarehouseResponse;
import com.jsp.warehouse.service.WarehouseService;
import com.jsp.warehouse.utility.ResponseStructure;

@RestControllerAdvice
//@RequestMapping("/api/version1")
public class WarehouseController {
	@Autowired
	private WarehouseService warehouseService;
	
	@GetMapping("/warehouses")
	public String createWarehouse(){
		return "Warehouse Found";
	}
}
