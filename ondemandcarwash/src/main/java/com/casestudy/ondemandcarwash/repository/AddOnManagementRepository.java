package com.casestudy.ondemandcarwash.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.ondemandcarwash.model.AddOnManagement;

public interface AddOnManagementRepository extends MongoRepository<AddOnManagement, Long>{
	
	AddOnManagement findById(int id);

	List<AddOnManagement> findByStatus(String status);
	

}
