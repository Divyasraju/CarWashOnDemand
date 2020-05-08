package com.casestudy.ondemandcarwash.operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.casestudy.ondemandcarwash.controller.OrderManagementController;
import com.casestudy.ondemandcarwash.model.Orders;
import com.casestudy.ondemandcarwash.repository.OrderManagementRepository;
import com.casestudy.ondemandcarwash.repository.WasherRepository;
import com.casestudy.ondemandcarwash.model.CarWasher;

@Component
public class ReportManagementOperation {

	@Autowired
	private OrderManagementRepository orderManagementRepository;

	@Autowired
	private WasherRepository washerRepository;

	@Autowired
	private OrderManagementController orderManagementController;

	public Orders getOrdersDetailsByOrderId(String orderId) {
		return orderManagementRepository.findByorderId(orderId);
	}

	public List<Orders> getOrdersDetailsByServiceType(String serviceType) {
		return orderManagementRepository.findByserviceType(serviceType);
	}

	public List<Orders> getOrdersDetailsByOrderDate(Date orderDate) {
		// TODO Auto-generated method stub
		return orderManagementRepository.findByorderDate(orderDate);
	}

}
