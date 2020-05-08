package com.casestudy.ondemandcarwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class CarDetails {
	@Id
	@JsonProperty()
	private String carNumber;
	@JsonProperty()
	private String carName;
	@JsonProperty()
	private String carModel;
	@JsonProperty()
	private String carOwnerName;
	@JsonProperty()
	private String status;

	public CarDetails(String carNumber, String carName, String carModel, String carOwnerName, String status) {
		super();
		this.carNumber = carNumber;
		this.carName = carName;
		this.carModel = carModel;
		this.carOwnerName = carOwnerName;
		this.status = status;
	}

	public CarDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarOwnerName() {
		return carOwnerName;
	}

	public void setCarOwnerName(String carOwnerName) {
		this.carOwnerName = carOwnerName;
	}

}
