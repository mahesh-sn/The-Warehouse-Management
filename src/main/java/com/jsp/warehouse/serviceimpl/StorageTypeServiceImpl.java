package com.jsp.warehouse.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.entity.StorageType;
import com.jsp.warehouse.mapper.StorageTypeMapper;
import com.jsp.warehouse.repo.StorageTypeRepo;
import com.jsp.warehouse.requestdto.StorageTypeRequest;
import com.jsp.warehouse.responsedto.StorageTypeResponse;
import com.jsp.warehouse.service.StorageTypeService;
import com.jsp.warehouse.utility.ResponseStructure;
@Service
public class StorageTypeServiceImpl implements StorageTypeService{

	@Autowired
	private StorageTypeRepo storageTypeRepo;
	
	@Autowired
	private StorageTypeMapper storageTypeMapper;
	
	@Override
	public ResponseEntity<ResponseStructure<StorageTypeResponse>> addStorageType(StorageTypeRequest storageTypeRequest) {
		StorageType storageType = storageTypeRepo.save(storageTypeMapper.mapToStorageType(storageTypeRequest,new StorageType()));
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseStructure<StorageTypeResponse>()
						.setData(storageTypeMapper.mapToStorageTypeResponse(storageType))
						.setMessage("StorageType Created")
						.setStatus(HttpStatus.CREATED.value()));
	}
}