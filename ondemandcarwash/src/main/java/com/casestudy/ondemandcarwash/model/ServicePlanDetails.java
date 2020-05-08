package com.casestudy.ondemandcarwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ServicePlanDetails {

	@Id
	private int id;
	private String serviceplan;
	private String description;
	private String status;

	public ServicePlanDetails() {
		super();
	}

	public ServicePlanDetails(int id, String serviceplan, String description, String status) {
		super();
		this.id = id;
		this.serviceplan = serviceplan;
		this.description = description;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServiceplan() {
		return serviceplan;
	}

	public void setServiceplan(String serviceplan) {
		this.serviceplan = serviceplan;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
