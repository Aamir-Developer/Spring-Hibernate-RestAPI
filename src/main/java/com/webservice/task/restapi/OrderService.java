package com.webservice.task.restapi;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository repo;

	public List<Orders> listAll() {
		return repo.findAll();
	}

	public Orders get(Integer orderNumber) {
		return repo.findById(orderNumber).get();
	}

}