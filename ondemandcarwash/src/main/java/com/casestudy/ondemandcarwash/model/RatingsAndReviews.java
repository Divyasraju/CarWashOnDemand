package com.casestudy.ondemandcarwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RatingsAndReviews {
	@Id
	private int id;
	private String rating;
	private String review;
	private String washerId;
	private String customerId;

	public RatingsAndReviews(int id, String rating, String review, String washerId, String customerId) {
		super();
		this.id = id;
		this.rating = rating;
		this.review = review;
		this.washerId = washerId;
		this.customerId = customerId;
	}

	public RatingsAndReviews() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getWasherId() {
		return washerId;
	}

	public void setWasherId(String washerId) {
		this.washerId = washerId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
