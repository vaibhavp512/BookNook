package com.sunbeam.services;

import com.sunbeam.entities.Admin;
import com.sunbeam.entities.Customer;

public interface AdminService {
	Admin findByadId(int id);
	Admin findByademail(String email);
	Admin save(Admin u);
	Admin authenticate(String email,String password);
}
