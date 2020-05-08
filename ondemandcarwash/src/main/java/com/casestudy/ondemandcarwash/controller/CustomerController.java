package com.casestudy.ondemandcarwash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.ondemandcarwash.model.Customer;
import com.casestudy.ondemandcarwash.model.RatingsAndReviews;
import com.casestudy.ondemandcarwash.operation.CustomerOperation;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerOperation customerOperation;

	@PostMapping("/addcustomer")
	public ResponseEntity<?> addCustomerDetails(@RequestBody Customer customer) {
		customerOperation.addCustomerDetails(customer);
		return new ResponseEntity<>("Saved", HttpStatus.OK);
	}

	@GetMapping("/customers")
	public List<Customer> findAllCustomerDetails() {
		return customerOperation.findAll();
	}

	@GetMapping("/viewRatings/{customerId}")
	public List<RatingsAndReviews> getRatingsAndReviewsByUserID(@PathVariable String customerId) {

		return customerOperation.getRatingsAndReviewsByUserID(customerId);

	}

}
