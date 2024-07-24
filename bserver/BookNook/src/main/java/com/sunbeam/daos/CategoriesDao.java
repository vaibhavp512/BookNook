package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Categories;

public interface CategoriesDao extends JpaRepository<Categories, Integer>{
	Categories findBycatId(int id);
}
