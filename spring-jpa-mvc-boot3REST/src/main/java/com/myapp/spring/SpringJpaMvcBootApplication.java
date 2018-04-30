package com.myapp.spring;

import java.util.Date;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myapp.spring.dao.OrderRepository;
import com.myapp.spring.model.Order;

@SpringBootApplication
public class SpringJpaMvcBootApplication implements CommandLineRunner {
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(SpringJpaMvcBootApplication.class, args);
		
	
	}

	@Override
	public void run(String... args) throws Exception {
		
		
//		orderRepository.save(new Order("Small",199,new Date()));
//		System.out.println(AopUtils.isAopProxy(orderRepository));
//		orderRepository.findAll().forEach(System.out::println);
//		
//		orderRepository.findByPrice(1123.0).forEach(System.out::println);
		
		orderRepository.findByNameNot("ORDERDER").forEach(System.out::println);;
		
		
		
	}
}
