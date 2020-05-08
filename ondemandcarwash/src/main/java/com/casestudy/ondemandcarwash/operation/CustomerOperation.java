package com.casestudy.ondemandcarwash.operation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.casestudy.ondemandcarwash.model.Customer;
import com.casestudy.ondemandcarwash.model.RatingsAndReviews;
import com.casestudy.ondemandcarwash.repository.CustomerRepository;
import com.casestudy.ondemandcarwash.repository.RatingsAndReviewsRepository;

@Component
public class CustomerOperation {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private RatingsAndReviewsRepository ratingsAndReviewsRepository;

	public void addCustomerDetails(Customer customer) {
		customerRepository.save(customer);
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();

	}

	public List<RatingsAndReviews> getRatingsAndReviewsByUserID(String customerId) {
		List<RatingsAndReviews> ratingsAndReviews = new ArrayList<>();
		ratingsAndReviews = ratingsAndReviewsRepository.findBycustomerId(customerId);
		return ratingsAndReviews;

	}
}
