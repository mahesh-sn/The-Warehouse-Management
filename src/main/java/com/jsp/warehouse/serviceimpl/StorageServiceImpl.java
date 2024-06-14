package com.jsp.warehouse.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.entity.Storage;
import com.jsp.warehouse.exception.WarehouseNotFoundByIdException;
import com.jsp.warehouse.mapper.StorageMapper;
import com.jsp.warehouse.repo.StorageRepo;
import com.jsp.warehouse.repo.WarehouseRepo;
import com.jsp.warehouse.requestdto.StorageRequest;
import com.jsp.warehouse.service.StorageService;
import com.jsp.warehouse.utility.SimpleResponseStructure;

@Service
public class StorageServiceImpl implements StorageService{
	@Autowired
	private StorageRepo storageRepo;
	
	@Autowired
	private WarehouseRepo warehouseRepo;
	
	@Autowired
	private StorageMapper storageMapper;
	
	@Override
	public ResponseEntity<SimpleResponseStructure<String>> addStorage(
			StorageRequest storageRequest, int warehouseId, int noOfStorageUnits) {

		return warehouseRepo.findById(warehouseId).map(warehouse->{
			
			List<Storage> storages=new ArrayList<Storage>();
			
			int storageUnits=noOfStorageUnits;
			
			while(storageUnits>0){
				
				Storage storage = storageMapper.mapToStorage(storageRequest, new Storage());
				storage.setAvailableArea(storageRequest.getLengthInMeters()*storageRequest.getBredthInMeters()*storageRequest.getHeightInMeters());
				storage.setMaxAdditionalWeightInKg(storageRequest.getCapacityInKg());
				storage.setWarehouse(warehouse);
				
				storages.add(storage);
				storageUnits--;
			}
			
			storageRepo.saveAll(storages);
			
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(new SimpleResponseStructure<String>()
							.setMessage("Storage Created")
							.setStatus(HttpStatus.CREATED.value()));
		}).orElseThrow(()->new WarehouseNotFoundByIdException("Invalid WareHouse"));
	}
}











