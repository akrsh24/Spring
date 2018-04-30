package com.myapp.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.spring.model.Order;

@Service
public interface OrderService  {

	List<Order> findAllByName(String name);
	
}
