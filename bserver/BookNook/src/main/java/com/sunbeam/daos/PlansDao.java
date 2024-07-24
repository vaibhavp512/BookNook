package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Plans;

public interface PlansDao extends JpaRepository<Plans, Integer> {
	Plans findByUid(int id);
	
}
