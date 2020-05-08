package com.casestudy.ondemandcarwash.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.ondemandcarwash.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

	List<Customer> findBycustomerId(String customerId);

}
