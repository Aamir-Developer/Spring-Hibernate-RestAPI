package com.webservice.task.restapi;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;

	@GetMapping("/orders")
	public List<Orders> list() {
		return service.listAll();
	}

	@GetMapping("/orders/{orderNumber}")
	public ResponseEntity<Orders> get(@PathVariable Integer orderNumber) {
		try {
			Orders order = service.get(orderNumber);
			return new ResponseEntity<Orders>(order, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
		}
	}

}