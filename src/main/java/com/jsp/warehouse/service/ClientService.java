package com.jsp.warehouse.service;

import org.springframework.http.ResponseEntity;

import com.jsp.warehouse.requestdto.ClientRequest;
import com.jsp.warehouse.responsedto.ApiKeyResponse;
import com.jsp.warehouse.utility.ResponseStructure;

public interface ClientService {

	ResponseEntity<ResponseStructure<ApiKeyResponse>> registerClients(ClientRequest clientRequest);

}
