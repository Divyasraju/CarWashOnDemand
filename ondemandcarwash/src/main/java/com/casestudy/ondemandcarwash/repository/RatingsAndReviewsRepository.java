package com.casestudy.ondemandcarwash.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.ondemandcarwash.model.RatingsAndReviews;

public interface RatingsAndReviewsRepository extends MongoRepository<RatingsAndReviews,Long>{

	List<RatingsAndReviews> findBywasherId(String washerId);

	List<RatingsAndReviews> findBycustomerId(String customerId);

}
