package com.casestudy.ondemandcarwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
	@Id
	private String customerId;
	private String customerName;
	private String address;
	private CarDetails cardetails;
	private RatingsAndReviews ratingsAndReviews;
	private Orders orders;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerId, String customerName, String address, CarDetails cardetails,
			RatingsAndReviews ratingsAndReviews, Orders orders) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.cardetails = cardetails;
		this.ratingsAndReviews = ratingsAndReviews;
		this.orders = orders;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public CarDetails getCardetails() {
		return cardetails;
	}

	public void setCardetails(CarDetails cardetails) {
		this.cardetails = cardetails;
	}

	public RatingsAndReviews getRatingsAndReviews() {
		return ratingsAndReviews;
	}

	public void setRatingsAndReviews(RatingsAndReviews ratingsAndReviews) {
		this.ratingsAndReviews = ratingsAndReviews;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}	
}
