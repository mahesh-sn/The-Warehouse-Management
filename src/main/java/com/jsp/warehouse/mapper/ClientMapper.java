package com.jsp.warehouse.mapper;

import org.springframework.stereotype.Component;

import com.jsp.warehouse.entity.Client;
import com.jsp.warehouse.requestdto.ClientRequest;
import com.jsp.warehouse.responsedto.ApiKeyResponse;
import com.jsp.warehouse.responsedto.ClientResponse;

@Component
public class ClientMapper {
	public Client mapToClient(ClientRequest clientRequest,Client client) {
		client.setBusinessName(clientRequest.getBusinessName());
		client.setContactNumber(clientRequest.getContactNumber());
		client.setEmail(clientRequest.getEmail());
		return client;
	}
	
	public ApiKeyResponse mapToApiKeyResponse(Client client) {
		return ApiKeyResponse.builder()
				.apiKey(client.getApiKey()).build();
	}

	public ClientResponse mapToClientResponse(Client client) {
		return ClientResponse.builder()
				.businessName(client.getBusinessName())
				.clientId(client.getClientId())
				.email(client.getEmail())
				.contactNumber(client.getContactNumber())
				.build();
	}
}