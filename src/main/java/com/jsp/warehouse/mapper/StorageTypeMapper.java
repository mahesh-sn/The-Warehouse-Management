package com.jsp.warehouse.mapper;

import org.springframework.stereotype.Component;

import com.jsp.warehouse.entity.StorageType;
import com.jsp.warehouse.requestdto.StorageTypeRequest;
import com.jsp.warehouse.responsedto.StorageTypeResponse;

@Component
public class StorageTypeMapper {
	public StorageType mapToStorageType(StorageTypeRequest storageTypeRequest,StorageType storageType) {
		storageType.setBredthInMeters(storageTypeRequest.getBredthInMeters());
		storageType.setCapacityInKg(storageTypeRequest.getCapacityInKg());
		storageType.setHeightInMeters(storageTypeRequest.getHeightInMeters());
		storageType.setLengthInMeters(storageTypeRequest.getLengthInMeters());
		return storageType;
	}
	
	public StorageTypeResponse mapToStorageTypeResponse(StorageType storageType) {
		return StorageTypeResponse.builder()
				.bredthInMeters(storageType.getBredthInMeters())
				.lengthInMeters(storageType.getLengthInMeters())
				.bredthInMeters(storageType.getBredthInMeters())
				.heightInMeters(storageType.getHeightInMeters())
				.capacityInKg(storageType.getCapacityInKg())
				.unitsAvailable(storageType.getUnitsAvailable())
				.build();
	}
	
}