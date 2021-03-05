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
	private Date requiredDate;
	private Date shippedDate;
	private String comments;
	private Integer customerNumber;

	public Orders() {
	}

	public Orders(Integer orderNumber, String status, Date orderDate, Date requiredDate, Date shippedDate,
			String comments, Integer customerNumber) {
		this.orderNumber = orderNumber;
		this.status = status;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.comments = comments;
		this.customerNumber = customerNumber;
	}

	@Column(name = "requiredDate")
	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	@Column(name = "shippedDate")
	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	@Column(name = "comments")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "customerNumber")
	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
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