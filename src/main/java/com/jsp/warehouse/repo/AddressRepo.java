package com.jsp.warehouse.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.warehouse.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

	public List<Address> findByCity(String city);

}
