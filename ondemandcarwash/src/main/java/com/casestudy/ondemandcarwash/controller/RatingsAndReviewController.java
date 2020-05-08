package com.casestudy.ondemandcarwash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.ondemandcarwash.model.RatingsAndReviews;
import com.casestudy.ondemandcarwash.repository.RatingsAndReviewsRepository;

@RestController
@RequestMapping("/api/reviews")
public class RatingsAndReviewController {
	
	@Autowired
	private RatingsAndReviewsRepository ratingsAndReviewsRepository;
	
	@PostMapping("/addreviewDetails")
	public ResponseEntity<?> insertReviewDetails(@RequestBody RatingsAndReviews ratingsAndReviews) {
		ratingsAndReviewsRepository.save(ratingsAndReviews);
		return new ResponseEntity<>("Saved", HttpStatus.OK);
	}

}
