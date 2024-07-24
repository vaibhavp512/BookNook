package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Publisher;

public interface PublisherService {
	Publisher findBypubId(int id);
	Publisher save(Publisher p);
	List<Publisher> findAll();

}
