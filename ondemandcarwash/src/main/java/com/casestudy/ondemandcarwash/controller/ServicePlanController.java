package com.casestudy.ondemandcarwash.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.ondemandcarwash.model.ServicePlanDetails;
import com.casestudy.ondemandcarwash.operation.ServicePlanOperation;

@RestController
@RequestMapping("/api/serviceplan")
public class ServicePlanController {

	@Autowired
	private ServicePlanOperation servicePlanOperation;

	@PostMapping("/addservice")
	public ResponseEntity<?> addNewServicePlan(@RequestBody ServicePlanDetails servicePlanDetails) {
		servicePlanOperation.addNewServicePlan(servicePlanDetails);
		return new ResponseEntity<>("Saved", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ServicePlanDetails> editServicePlan(@PathVariable(value = "id") int id,
	  @Valid @RequestBody ServicePlanDetails servicePlanDetails) throws Exception {
		return servicePlanOperation.editServicePlan(id,servicePlanDetails);
	}
	
	@GetMapping("/getstatus")
	public List<ServicePlanDetails> getservicePlanBasedOnStatus(@RequestParam String status){
		return servicePlanOperation.getservicePlanBasedOnStatus(status);
	}
}
