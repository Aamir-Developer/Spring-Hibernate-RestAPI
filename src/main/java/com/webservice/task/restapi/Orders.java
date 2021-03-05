package com.webservice.task.restapi;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	private Integer orderNumber;
	private String status;
	private Date orderDate;

	public Orders() {
	}

	public Orders(Integer orderNumber, String status, Date orderDate) {
		this.orderNumber = orderNumber;
		this.status = status;
		this.orderDate = orderDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderNumber")
	public Integer getNumber() {
		return orderNumber;
	}

	public void setNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "orderDate")
	public Date getDate() {
		return orderDate;
	}

	public void setDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}