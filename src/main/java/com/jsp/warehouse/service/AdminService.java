package com.jsp.warehouse.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
import com.jsp.warehouse.utility.ResponseStructure;

public interface AdminService {

	ResponseEntity<ResponseStructure<AdminResponse>> saveSuperAdmin(AdminRequest adminRequest);

	ResponseEntity<ResponseStructure<AdminResponse>> createAdmins(AdminRequest adminRequest, int warehouseId);

	ResponseEntity<ResponseStructure<AdminResponse>> UpdateAdimin(AdminRequest adminRequest);

	ResponseEntity<ResponseStructure<AdminResponse>> updateAdiminBySuperAdmin(AdminRequest adminRequest, int adminId);

	ResponseEntity<ResponseStructure<AdminResponse>> findAdminById(int adminId);

	ResponseEntity<ResponseStructure<List<AdminResponse>>> findAdmins();
	
}
