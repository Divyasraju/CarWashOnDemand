package com.casestudy.ondemandcarwash.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.ondemandcarwash.model.ServicePlanDetails;

public interface ServicePlanRepository extends MongoRepository<ServicePlanDetails, Long>{

	ServicePlanDetails findById(int id);

	List<ServicePlanDetails> findByStatus(String status);

}
