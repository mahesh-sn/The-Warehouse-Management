package com.jsp.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.warehouse.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
