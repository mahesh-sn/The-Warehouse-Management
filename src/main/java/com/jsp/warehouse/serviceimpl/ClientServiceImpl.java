package com.jsp.warehouse.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.entity.Client;
import com.jsp.warehouse.mapper.ClientMapper;
import com.jsp.warehouse.requestdto.ClientRequest;
import com.jsp.warehouse.responsedto.ApiKeyResponse;
import com.jsp.warehouse.service.ClientService;
import com.jsp.warehouse.utility.ResponseStructure;

@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
	private ClientRepo clientRepo;

	@Autowired
	private ClientMapper clientMapper;
	
	@Override
	public ResponseEntity<ResponseStructure<ApiKeyResponse>> registerClients(ClientRequest clientRequest) {
		Client client= clientRepo.save(clientMapper.mapToClient(clientRequest,new Client()));
		String apiKey = UUID.randomUUID().toString();
		client.setApiKey(apiKey);
		clientRepo.save(client);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseStructure<ApiKeyResponse>()
						.setData(clientMapper.mapToApiKeyResponse(client))
						.setMessage("Client Registered")
						.setStatus(HttpStatus.CREATED.value()));
	}
	
	
	
}
