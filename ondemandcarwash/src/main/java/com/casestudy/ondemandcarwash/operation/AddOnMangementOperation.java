package com.casestudy.ondemandcarwash.operation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.casestudy.ondemandcarwash.model.AddOnManagement;
import com.casestudy.ondemandcarwash.repository.AddOnManagementRepository;

@Component
public class AddOnMangementOperation {
	
	@Autowired
	private AddOnManagementRepository addOnManagementRepository;

	public void addNewAddOnPlan(AddOnManagement addOnManagement) {
		addOnManagementRepository.save(addOnManagement);
		
	}

	public ResponseEntity<AddOnManagement> updateAddOnPlan(int id, @Valid AddOnManagement addOnManagement) {
		AddOnManagement addOnManagementDetail = addOnManagementRepository.findById(id);
		if (addOnManagementDetail != null) {
			addOnManagementDetail.setAddOnPlan(addOnManagement.getAddOnPlan());
			addOnManagementDetail.setDescription(addOnManagement.getDescription());
			return new ResponseEntity<>(addOnManagementRepository.save(addOnManagementDetail), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	public List<AddOnManagement> getAddOnServicesBasedOnStatus(String status) {
		List<AddOnManagement> addOnManagementDetails = new ArrayList<>();
		if (status == "Active") {
			addOnManagementDetails = addOnManagementRepository.findByStatus(status);
		} else {
			addOnManagementDetails = addOnManagementRepository.findByStatus(status);
		}
		return addOnManagementDetails;
	}

}
