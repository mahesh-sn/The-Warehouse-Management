package com.jsp.warehouse.serviceimpl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.warehouse.entity.Client;

public interface ClientRepo extends JpaRepository<Client, Integer>{

}
