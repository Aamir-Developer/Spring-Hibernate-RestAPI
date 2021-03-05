package com.webservice.task.restapi;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;

	@GetMapping("/orders")
	public OrderDetailsList list(@RequestParam(value = "startDate") final String startDate,
			@RequestParam(value = "endDate") final String endDate) {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date startDateObject = Date.from(LocalDate.parse(startDate).atStartOfDay(defaultZoneId).toInstant());
		Date endDateObject = Date.from(LocalDate.parse(endDate).atStartOfDay(defaultZoneId).toInstant());
		List<Orders> allorders = service.listAll();
		OrderDetailsList orderDetailsList = new OrderDetailsList();
		List<OrderDetails> allOrderDetails = new ArrayList<OrderDetails>();
		for (Orders order : allorders) {
			if ((order.getOrderDate().after(startDateObject) && order.getOrderDate().before(endDateObject))
					|| order.getOrderDate().compareTo(startDateObject) == 0
					|| order.getOrderDate().compareTo(endDateObject) == 0) {
				OrderDetails orderDetails = new OrderDetails();
				orderDetails.setOrderDate(order.getOrderDate());
				orderDetails.setOrderNumber(order.getOrderNumber());
				orderDetails.setStatus(order.getStatus());
				allOrderDetails.add(orderDetails);
			}
			orderDetailsList.setOrderDetails(allOrderDetails);
		}
		return orderDetailsList;
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