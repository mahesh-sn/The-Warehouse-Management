package com.jsp.warehouse.mapper;

import org.springframework.stereotype.Component;

import com.jsp.warehouse.entity.Storage;
import com.jsp.warehouse.requestdto.StorageRequest;

@Component
public class StorageMapper {
	public Storage mapToStorage(StorageRequest storageRequest,Storage storage) {
		storage.setBlockName(storageRequest.getBlockName());
		storage.setSection(storageRequest.getSection());
		storage.setLengthInMeters(storageRequest.getLengthInMeters());
		storage.setBredthInMeters(storageRequest.getBredthInMeters());
		storage.setHeightInMeters(storageRequest.getHeightInMeters());
		storage.setCapacityInKg(storageRequest.getCapacityInKg());
		storage.setMaterialTypes(storageRequest.getMaterialTypes());
		return storage;
	}
}