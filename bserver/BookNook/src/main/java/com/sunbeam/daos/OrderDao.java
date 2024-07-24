package com.sunbeam.daos;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Author;
import com.sunbeam.entities.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{

	Order findByOid(int id);
	List<Order> findByUid(int id);
	List<Order> findByDid(int id);
	@Query(
			value = "select o.uid from orders o",
			nativeQuery = true
	)
	Set<Integer> findAllByUid();
	List<Order> findByuidOrderByOdateDesc(int id);

}
