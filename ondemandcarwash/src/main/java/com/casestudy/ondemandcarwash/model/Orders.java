package com.casestudy.ondemandcarwash.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Orders {
	@Id
	private int id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date orderDate;
	private String orderStatus;
	private String orderId;
	private String serviceType;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int id, Date orderDate, String orderStatus, String orderId, String serviceType) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.orderId = orderId;
		this.serviceType = serviceType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

}
