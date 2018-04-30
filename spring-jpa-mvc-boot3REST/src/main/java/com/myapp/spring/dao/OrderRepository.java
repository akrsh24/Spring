package com.myapp.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.spring.model.Order;


@Repository
@Transactional(propagation=Propagation.REQUIRED)
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByPrice(Double price);
	
	List<Order> findByNameIgnoreCaseStartingWith(String orderName);
	
	List<Order> findByNameNotLikeOrderByNameAsc(String stateName);
	
	List<Order> findByNameIsOrPriceEquals(String value, double value2);
	
	List<Order> findByNameNot(String name);
	
	
	

}
