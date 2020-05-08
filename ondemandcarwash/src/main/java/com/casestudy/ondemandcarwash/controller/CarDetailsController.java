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

import com.casestudy.ondemandcarwash.model.CarDetails;
import com.casestudy.ondemandcarwash.operation.CarDetailsOperation;

@RestController
@RequestMapping("/api")
public class CarDetailsController {

	@Autowired
	private CarDetailsOperation carDetailsOperation;

	@PostMapping("/addcars")
	public ResponseEntity<?> addCarDetails(@RequestBody CarDetails carDetails) {
		carDetailsOperation.addCarDetails(carDetails);
		return new ResponseEntity<>("Saved", HttpStatus.OK);
	}

	@GetMapping("/car/{carno}")
	public CarDetails getCarDetails(@PathVariable String carno) {
		return carDetailsOperation.getCarDetails(carno);
	}

	@GetMapping("/cars")
	public List<CarDetails> findAllCarDetails() {
        return carDetailsOperation.findAll();
    }
	
	@PutMapping("/car/{carno}")
	public ResponseEntity<CarDetails> updateCarDetails(@PathVariable(value = "carno") String carno,
	  @Valid @RequestBody CarDetails carDetails) throws Exception {
		return carDetailsOperation.updateCarDetailsByCarno(carno,carDetails);
	}
	
	@GetMapping("/getstatus")
	public List<CarDetails> getCarDetailsBasedOnStatus(@RequestParam String status){
		return carDetailsOperation.getCarDetailsBasedOnStatus(status);
	}
}