package com.casestudy.ondemandcarwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PromoCode {

	@Id
	private int id;
	private String promoCode;

	public PromoCode(int id, String promoCode) {
		super();
		this.id = id;
		this.promoCode = promoCode;
	}

	public PromoCode() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

}
