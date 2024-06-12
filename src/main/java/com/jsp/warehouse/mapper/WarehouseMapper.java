package com.jsp.warehouse.mapper;

import org.springframework.stereotype.Component;

import com.jsp.warehouse.entity.Warehouse;
import com.jsp.warehouse.requestdto.WarehouseRequset;
import com.jsp.warehouse.responsedto.WarehouseResponse;

@Component
public class WarehouseMapper {
	
	public Warehouse mapToWarehouse(WarehouseRequset warehouseRequset,Warehouse warehouse) {
		warehouse.setName(warehouseRequset.getName());
		return warehouse;
	}
	public WarehouseResponse mapToWarehouseResponse(Warehouse  warehouse) {
		return WarehouseResponse.builder()
				.name(warehouse.getName())
				.warehouseId(warehouse.getWarehouseId())
				.totalCapacity(0)
				.build();
	}
}
