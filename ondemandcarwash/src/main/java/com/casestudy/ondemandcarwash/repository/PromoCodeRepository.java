package com.casestudy.ondemandcarwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.ondemandcarwash.model.PromoCode;

public interface PromoCodeRepository extends MongoRepository<PromoCode, Long>{

	PromoCode findById(int id);

}
