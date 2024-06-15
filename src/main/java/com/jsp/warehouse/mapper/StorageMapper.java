package com.jsp.warehouse.mapper;

import org.springframework.stereotype.Component;

import com.jsp.warehouse.entity.Storage;
import com.jsp.warehouse.requestdto.StorageRequest;
import com.jsp.warehouse.responsedto.StorageResponse;

@Component
public class StorageMapper {
	public Storage mapToStorage(StorageRequest storageRequest,Storage storage) {
		storage.setBlockName(storageRequest.getBlockName());
		storage.setSection(storageRequest.getSection());
		storage.setLengthInMeters(storageRequest.getLengthInMeters());
		storage.setBredthInMeters(storageRequest.getBredthInMeters());
		storage.setCapacityInKg(storageRequest.getCapacityInKg());
		storage.setHeightInMeters(storageRequest.getHeightInMeters());
		storage.setMaterialTypes(storageRequest.getMaterialTypes());
		return storage;
	}

	public StorageResponse mapToStorageResponse(Storage storage) {
		return StorageResponse.builder()
				.storageId(storage.getStorageId())
				.blockname(storage.getBlockName())
				.section(storage.getSection())
				.capacityInKg(storage.getCapacityInKg())
				.materialTypes(storage.getMaterialTypes())
				.build();
	}
}