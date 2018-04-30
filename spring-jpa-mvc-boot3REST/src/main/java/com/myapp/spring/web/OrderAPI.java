package com.myapp.spring.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.dao.OrderRepository;
import com.myapp.spring.model.Order;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
public class OrderAPI {

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping(value = "/orders", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }) // content
																														// negotiation

	// @GetMapping(value ="/orders") //removed produces= MediaTypes, so that it
	// could work directly in browser.. or else ADD
	// <groupId>com.fasterxml.jackson.dataformat</groupId><artifactId>jackson-dataformat-xml</artifactId>
	// to Pom.xml and then use the produces= ....
	public List<Order> loadAll() {

		return orderRepository.findAll();

	}

	@GetMapping("/orders/{id}")
	public Order loadById(@PathVariable("id") long id) {

		return orderRepository.getOne(id);

	}

	@PostMapping(value = "/orders", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> placeAnOrder(@RequestBody Order order) {
		orderRepository.save(order);
		return new ResponseEntity<String>("Order Created", HttpStatus.CREATED);

	}
	
	@PostMapping(value = "/orders/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> updateAnOrder(@PathVariable("id") long id,@RequestBody Order order) {
		Order existingorder=orderRepository.getOne(id);
		BeanUtils.copyProperties(order, existingorder);
		orderRepository.save(existingorder);  // .save can do both save and update(if record exists, then update, else save
		return new ResponseEntity<String>("Order updated", HttpStatus.CREATED);

	}
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable("id") long id){
		Order order = orderRepository.getOne(id);
		orderRepository.delete(order);
		return new ResponseEntity<String>("order Deleted", HttpStatus.OK);
	}

}
