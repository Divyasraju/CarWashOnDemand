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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.ondemandcarwash.model.Orders;
import com.casestudy.ondemandcarwash.operation.OrderManagementOperation;

@RestController
@RequestMapping("/api/order")
public class OrderManagementController {

	@Autowired
	private OrderManagementOperation orderManagementOperation;

	@PostMapping("/addorder")
	public ResponseEntity<?> addOrderDetails(@RequestBody Orders orders) {
		orderManagementOperation.addOrderDetails(orders);
		return new ResponseEntity<>("Saved", HttpStatus.OK);
	}

	@GetMapping("/{orderId}")
	public Orders getCarDetails(@PathVariable String orderId) {
		return orderManagementOperation.getOrderDetails(orderId);
	}

	@GetMapping("/allorders")
	public List<Orders> findAllOrderDetails() {
		return orderManagementOperation.findAll();
	}

	@GetMapping("/assignorders")
	public String assignOrdersToCarWasher() {
		return orderManagementOperation.assignOrdersToCarWasher();

	}

	@GetMapping("/orderbasedonstatus")
	public List<Orders> getAllOrderDetailsBasedOrderStatus(@RequestParam String status) {
		return orderManagementOperation.getAllOrderDetailsBasedOrderStatus(status);

	}

}
