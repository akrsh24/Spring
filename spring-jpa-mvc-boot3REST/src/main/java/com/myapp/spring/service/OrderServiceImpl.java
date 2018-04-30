package com.myapp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.spring.dao.OrderRepository;
import com.myapp.spring.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> findAllByName(String name) {
		
		return orderRepository.findByNameIgnoreCaseStartingWith(name);
		
	}

}
