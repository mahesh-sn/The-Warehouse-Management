package com.jsp.warehouse.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.entity.Warehouse;
import com.jsp.warehouse.exception.WarehouseNotFoundByIdException;
import com.jsp.warehouse.mapper.WarehouseMapper;
import com.jsp.warehouse.repo.WarehouseRepo;
import com.jsp.warehouse.requestdto.WarehouseRequset;
import com.jsp.warehouse.responsedto.WarehouseResponse;
import com.jsp.warehouse.service.WarehouseService;
import com.jsp.warehouse.utility.ResponseStructure;

@Service
public class WarehouseServiceimpl implements WarehouseService{
	@Autowired
	private WarehouseRepo warehouseRepo;

	@Autowired
	private WarehouseMapper warehouseMapper;

	@Override
	public ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(WarehouseRequset warehouseRequset) {

		Warehouse warehouse = warehouseMapper.mapToWarehouse(warehouseRequset, new Warehouse());
		warehouse= warehouseRepo.save(warehouse);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseStructure<WarehouseResponse>()
						.setData(warehouseMapper.mapToWarehouseResponse(warehouse))
						.setMessage("Created Warehouse")
						.setStatus(HttpStatus.CREATED.value()));

	}

	@Override
	public ResponseEntity<ResponseStructure<WarehouseResponse>> findWarehouse(int warehouseId) {
		return warehouseRepo.findById(warehouseId).map(warehouse->{
			
			return ResponseEntity
					.status(HttpStatus.FOUND)
					.body(new ResponseStructure<WarehouseResponse>()
							.setData(warehouseMapper.mapToWarehouseResponse(warehouse))
							.setMessage("Found All WareHouses Details")
							.setStatus(HttpStatus.FOUND.value()));
		
		}).orElseThrow(()->new WarehouseNotFoundByIdException("Invalid WareHouse"));

	}
}








