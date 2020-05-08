package com.casestudy.ondemandcarwash.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.ondemandcarwash.model.CarWasher;

public interface WasherRepository extends MongoRepository<CarWasher,Long>{

	CarWasher findById(int id);

	List<CarWasher> findBywasherId(String washerId);

	CarWasher findBywasherName(String washerName);
	}
