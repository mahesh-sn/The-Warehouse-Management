package com.jsp.warehouse.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.entity.Admin;
import com.jsp.warehouse.enums.AdminType;
import com.jsp.warehouse.exception.AdminNotFoundByEmailException;
import com.jsp.warehouse.exception.AdminNotFoundByIdException;
import com.jsp.warehouse.exception.IllegalOperationException;
import com.jsp.warehouse.exception.WarehouseNotFoundByIdException;
import com.jsp.warehouse.mapper.AdminMapper;
import com.jsp.warehouse.repo.AdminRepo;
import com.jsp.warehouse.repo.WarehouseRepo;
import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
import com.jsp.warehouse.service.AdminService;
import com.jsp.warehouse.utility.ResponseStructure;

@Service
public class AdminServiceImpl implements  AdminService{
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private AdminMapper adminMapper; 
	@Autowired
	private WarehouseRepo warehouseRepo;

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> saveSuperAdmin(AdminRequest adminRequest) {
		if(adminRepo.existsByAdminType(AdminType.SUPER_ADMIN)) {
			throw new IllegalOperationException("Illegal Operation to add a Supre Admin");
		}else {
			Admin admin = adminMapper.mapToAdmin(adminRequest,new Admin());
			admin.setAdminType(AdminType.SUPER_ADMIN);
			admin = adminRepo.save(admin);
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(new ResponseStructure<AdminResponse>()
							.setData(adminMapper.mapToAdminResponse(admin))
							.setMessage("Admin Saved Successfully")
							.setStatus(HttpStatus.CREATED.value()));
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> createAdmins(AdminRequest adminRequest,int warehouseId) {
		return warehouseRepo.findById(warehouseId).map(warehouse->{
			Admin admin = adminMapper.mapToAdmin(adminRequest, new Admin());
			admin.setAdminType(AdminType.ADMIN);

			admin=adminRepo.save(admin);

			warehouse.setAdmin(admin);
			warehouseRepo.save(warehouse);

			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(new ResponseStructure<AdminResponse>()
							.setData(adminMapper.mapToAdminResponse(admin))
							.setMessage("Admin Created")
							.setStatus(HttpStatus.CREATED.value()));
			
		}).orElseThrow(()->new WarehouseNotFoundByIdException("Invalid WareHouse"));
	}

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> UpdateAdimin(AdminRequest adminRequest) {
		String email=SecurityContextHolder.getContext().getAuthentication().getName();
		return adminRepo.findByEmail(email).map(admin->{
			admin=adminMapper.mapToAdmin(adminRequest, admin);
			admin=adminRepo.save(admin);

			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseStructure<AdminResponse>()
							.setData(adminMapper.mapToAdminResponse(admin))
							.setMessage("Updated sucessfully")
							.setStatus(HttpStatus.OK.value()));
		}).orElseThrow(()->new AdminNotFoundByEmailException("Illegal Operation"));
	}

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdiminBySuperAdmin(AdminRequest adminRequest,
			int adminId) {
		return adminRepo.findById(adminId).map(admin->{
			admin = adminRepo.save(adminMapper.mapToAdmin(adminRequest, admin));
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseStructure<AdminResponse>()
							.setData(adminMapper.mapToAdminResponse(admin))
							.setMessage("Admin Updated")
							.setStatus(HttpStatus.OK.value()));
		}).orElseThrow(()->new AdminNotFoundByIdException("Invalid Id"));
	}

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdminById(int adminId) {
		return adminRepo.findById(adminId).map(admin->{
			return ResponseEntity
					.status(HttpStatus.FOUND)
					.body(new ResponseStructure<AdminResponse>()
							.setData(adminMapper.mapToAdminResponse(admin))
							.setMessage("Admin Details with the Id:"+adminId+" found")
							.setStatus(HttpStatus.FOUND.value()));							
		}).orElseThrow(()->new AdminNotFoundByIdException("Invalid Id"));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<AdminResponse>>> findAdmins() {
		List<AdminResponse>adminResponses= adminRepo.findByAdminType(AdminType.ADMIN).stream().map(admins->
		adminMapper.mapToAdminResponse(admins)).toList();

		return ResponseEntity
				.status(HttpStatus.FOUND)
				.body(new ResponseStructure<List<AdminResponse>>()
						.setData(adminResponses)
						.setMessage("All Admin Details Found")
						.setStatus(HttpStatus.FOUND.value()));
	}

}










