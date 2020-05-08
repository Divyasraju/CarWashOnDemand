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

import com.casestudy.ondemandcarwash.model.AddOnManagement;
import com.casestudy.ondemandcarwash.operation.AddOnMangementOperation;

@RestController
@RequestMapping("/api/addonplan")
public class AddOnMangementController {
	
	@Autowired
	private AddOnMangementOperation addOnMangementOperation;

	@PostMapping("/addservice")
	public ResponseEntity<?> addNewAddOnPlan(@RequestBody AddOnManagement addOnManagement) {
		addOnMangementOperation.addNewAddOnPlan(addOnManagement);
		return new ResponseEntity<>("Saved", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AddOnManagement> updateAddOnPlan(@PathVariable(value = "id") int id,
	  @Valid @RequestBody AddOnManagement addOnManagement) throws Exception {
		return addOnMangementOperation.updateAddOnPlan(id,addOnManagement);
	}
	
	@GetMapping("/getstatus")
	public List<AddOnManagement> getAddOnBasedOnStatus(@RequestParam String status){
		return addOnMangementOperation.getAddOnServicesBasedOnStatus(status);
	}
	

}
