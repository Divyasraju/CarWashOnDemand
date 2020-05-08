package com.casestudy.ondemandcarwash.operation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.casestudy.ondemandcarwash.model.ServicePlanDetails;
import com.casestudy.ondemandcarwash.repository.ServicePlanRepository;

@Component
public class ServicePlanOperation {

	@Autowired
	private ServicePlanRepository servicePlanRepository;

	public void addNewServicePlan(ServicePlanDetails servicePlanDetails) {
		servicePlanRepository.save(servicePlanDetails);

	}

	public ResponseEntity<ServicePlanDetails> editServicePlan(int id, @Valid ServicePlanDetails servicePlanDetails) {
		ServicePlanDetails servicePlanDetail = servicePlanRepository.findById(id);
		if (servicePlanDetail != null) {
			servicePlanDetail.setServiceplan(servicePlanDetails.getServiceplan());
			servicePlanDetail.setDescription(servicePlanDetails.getDescription());
			return new ResponseEntity<>(servicePlanRepository.save(servicePlanDetail), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	public List<ServicePlanDetails> getservicePlanBasedOnStatus(String status) {
		List<ServicePlanDetails> servicePlanDetails = new ArrayList<>();
		if (status == "Active") {
			servicePlanDetails = servicePlanRepository.findByStatus(status);
		} else {
			servicePlanDetails = servicePlanRepository.findByStatus(status);
		}
		return servicePlanDetails;
	}

}
