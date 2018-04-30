package com.myapp.spring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.spring.model.Order;
import com.myapp.spring.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@ModelAttribute("order")
	public Order formBackingObjectAnyNAme() {
		return new Order();
	}
	
	
//	//Path type
//	//http://IP:PORT/orders/Order1
//	//same as RequestMapping but GetMaping is more convenient, added in newer versions of spring.
//	@GetMapping("/orders/{name}")
//	public ModelAndView search(@PathVariable("name")String orderName) {
//		
//		List<Order> orders = orderService.findAllByName(orderName);
//		
//		return new ModelAndView("search", "orders", orders);
//		
//	}
	
	
	//-----------as per the current jsp view we have made, to make it work--> neeche wala code---------
	
	//Path type
	//http://IP:PORT/orders/Order1
	//same as RequestMapping but GetMaping is more convenient, added in newer versions of spring.
	
	
	@GetMapping("/")
	public String home() {
		return "home";	
	}
	
		
	@GetMapping("/search")
	public ModelAndView search(Order order) {
		
		List<Order> orders = orderService.findAllByName(order.getName());
		
		return new ModelAndView("home", "orders", orders);
		
	}
	
	//----------------------------------------------------------------------------------------------
	
	
	//Query type
	//http://IP:PORT/orders?name=Order1
	@GetMapping("/orders")
	public ModelAndView search1(@RequestParam("name")String orderName) {
		
		List<Order> orders = orderService.findAllByName(orderName);
		
		return new ModelAndView("search", "orders", orders);
	}
	
	
	
}
