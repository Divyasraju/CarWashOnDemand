package com.casestudy.ondemandcarwash.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.ondemandcarwash.model.CarDetails;

public interface CarDetailsRepository extends MongoRepository<CarDetails, String> {

	CarDetails findBycarNumber(String carno);
	
	List<CarDetails> findByStatus(String status);
}
