package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.PlansDetails;


public interface PlansDetailsService {

	PlansDetails save(PlansDetails pd);
	PlansDetails findByPlid(int id);
	List<PlansDetails> findAll();
}
