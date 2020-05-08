package com.casestudy.ondemandcarwash.operation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.casestudy.ondemandcarwash.model.CarDetails;
import com.casestudy.ondemandcarwash.repository.CarDetailsRepository;

@Component
public class CarDetailsOperation {

	@Autowired
	private CarDetailsRepository carDetailsRepository;

	public void addCarDetails(CarDetails carDetails) {
		carDetailsRepository.save(carDetails);
	}

	public CarDetails getCarDetails(String carno) {
		return carDetailsRepository.findBycarNumber(carno);

	}

	public List<CarDetails> findAll() {
		return carDetailsRepository.findAll();
	}

	public ResponseEntity<CarDetails> updateCarDetailsByCarno(String carno, @Valid CarDetails carDetails) {
		CarDetails carDetail = carDetailsRepository.findBycarNumber(carno);
		if (carDetail != null) {
			carDetail.setCarModel(carDetails.getCarModel());
			carDetail.setCarName(carDetails.getCarName());
			carDetail.setCarNumber(carDetails.getCarNumber());
			carDetail.setCarOwnerName(carDetails.getCarOwnerName());
			return new ResponseEntity<>(carDetailsRepository.save(carDetail), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	public List<CarDetails> getCarDetailsBasedOnStatus(String status) {
		List<CarDetails> carDetails = new ArrayList<>();
		if (status == "Active") {
			carDetails = carDetailsRepository.findByStatus(status);
		} else {
			carDetails = carDetailsRepository.findByStatus(status);
		}
		return carDetails;
	}

}
