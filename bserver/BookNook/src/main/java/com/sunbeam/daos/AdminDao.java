package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer>{
	Admin findByadId(int id);
	Admin findByademail(String email);
}
