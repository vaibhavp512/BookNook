package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Address;

public interface AddressDao extends JpaRepository<Address, Integer>{
	
}
