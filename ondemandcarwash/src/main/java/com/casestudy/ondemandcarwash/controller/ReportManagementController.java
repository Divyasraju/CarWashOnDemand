package com.casestudy.ondemandcarwash.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.ondemandcarwash.operation.ReportManagementOperation;
import com.casestudy.ondemandcarwash.model.Orders;

@RestController
@RequestMapping("/api/reports")
public class ReportManagementController {

	@Autowired
	private ReportManagementOperation reportManagementOperation;

	@GetMapping("/orderFilter")
	public Orders getOrdersDetailsByOrderId(@RequestParam String orderId) {
		return reportManagementOperation.getOrdersDetailsByOrderId(orderId);
	}

	@GetMapping("/filterByType")
	public List<Orders> getOrdersDetailsByWasherName(@RequestParam String serviceType) {
		return reportManagementOperation.getOrdersDetailsByServiceType(serviceType);
	}

	@GetMapping("/filterByDate")
	public List<Orders> getOrdersDetailsByOrderDate(
			@RequestParam("orderDate") @DateTimeFormat(pattern = "dd.MM.yyyy") Date orderDate) {
		return reportManagementOperation.getOrdersDetailsByOrderDate(orderDate);
	}

}
