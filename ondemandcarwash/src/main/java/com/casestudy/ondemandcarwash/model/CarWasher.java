package com.casestudy.ondemandcarwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CarWasher {
	@Id
	private int id;
	private String washerName;
	private String washerNo;
	private String mailId;
	private Orders orders;
	private String washerId;

	public CarWasher() {
		super();
	}

	public CarWasher(int id, String washerName, String washerNo, String mailId, Orders orders, String washerId) {
		super();
		this.id = id;
		this.washerName = washerName;
		this.washerNo = washerNo;
		this.mailId = mailId;
		this.orders = orders;
		this.washerId = washerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWasherName() {
		return washerName;
	}

	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}

	public String getWasherNo() {
		return washerNo;
	}

	public void setWasherNo(String washerNo) {
		this.washerNo = washerNo;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getWasherId() {
		return washerId;
	}

	public void setWasherId(String washerId) {
		this.washerId = washerId;
	}

}
