package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Publisher;

public interface PublisherDao extends JpaRepository<Publisher, Integer>{
	Publisher findBypubId(int id);
}
