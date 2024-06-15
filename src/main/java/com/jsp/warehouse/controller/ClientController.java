package com.jsp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.requestdto.ClientRequest;
import com.jsp.warehouse.responsedto.ApiKeyResponse;
import com.jsp.warehouse.responsedto.WarehouseResponse;
import com.jsp.warehouse.service.ClientService;
import com.jsp.warehouse.utility.ResponseStructure;

@RestController
@RequestMapping("api/version1")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/clients")
	public ResponseEntity<ResponseStructure<ApiKeyResponse>> registerClients(@RequestBody ClientRequest clientRequest){
		return clientService.registerClients(clientRequest);
	}
	
}
