package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Book;
import com.sunbeam.entities.Categories;

public interface CategoriesService {
	Categories findBycatId(int id);
	Categories save(Categories c);
	List<Categories> findAll();
	void deleteById(int id);
}
