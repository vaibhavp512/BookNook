package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.PlansDetails;

public interface PlansDetailsDao extends JpaRepository<PlansDetails, Integer> {

	PlansDetails findByPlid(int id);
}
