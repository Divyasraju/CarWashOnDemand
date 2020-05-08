package com.casestudy.ondemandcarwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AddOnManagement {

	@Id
	private int id;
	private String addOnPlan;
	private String description;
	private String status;

	public AddOnManagement(int id, String addOnPlan, String description, String status) {
		super();
		this.id = id;
		this.addOnPlan = addOnPlan;
		this.description = description;
		this.status = status;
	}

	public AddOnManagement() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddOnPlan() {
		return addOnPlan;
	}

	public void setAddOnPlan(String addOnPlan) {
		this.addOnPlan = addOnPlan;
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

	@Override
	public String toString() {
		return "AddOnManagement [id=" + id + ", addOnPlan=" + addOnPlan + ", description=" + description + "]";
	}

}
