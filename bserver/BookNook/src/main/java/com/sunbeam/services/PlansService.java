package com.sunbeam.services;

import com.sunbeam.entities.Plans;

public interface PlansService {

	Plans findByUid(int id);
	Plans save(Plans p);
}
