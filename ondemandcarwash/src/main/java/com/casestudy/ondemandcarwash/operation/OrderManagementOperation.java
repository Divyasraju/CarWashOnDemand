package com.casestudy.ondemandcarwash.operation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.casestudy.ondemandcarwash.model.CarWasher;
import com.casestudy.ondemandcarwash.model.Orders;
import com.casestudy.ondemandcarwash.repository.OrderManagementRepository;
import com.casestudy.ondemandcarwash.repository.WasherRepository;

@Component
public class OrderManagementOperation {

	@Autowired
	private OrderManagementRepository orderManagementRepository;

	@Autowired
	private WasherRepository washerRepository;

	public void addOrderDetails(Orders orders) {
		orderManagementRepository.save(orders);

	}

	public Orders getOrderDetails(String orderId) {
		return orderManagementRepository.findByorderId(orderId);
	}

	public List<Orders> findAll() {
		return orderManagementRepository.findAll();
	}

	public String assignOrdersToCarWasher() {
		String orderStatus = "pending";
		List<Orders> orderDetails = orderManagementRepository.findByorderStatus(orderStatus);
		if (!orderDetails.isEmpty()) {
			List<CarWasher> carWasherDetails = washerRepository.findAll();
			for (CarWasher carwasher : carWasherDetails) {
				for (Orders orders : orderDetails) {
					carwasher.getId();
					carwasher.getMailId();
					carwasher.getWasherId();
					carwasher.getWasherName();
					carwasher.getWasherNo();
					carwasher.setOrders(orders);
					washerRepository.save(carwasher);
					orders.getId();
					orders.getOrderDate();
					orders.getOrderId();
					orders.setOrderStatus("under process");
					orderManagementRepository.save(orders);
				}
			}

		} else {
			return "no pending orders";
		}
		return "Order is assigned to a washer";
	}

	public List<Orders> getAllOrderDetailsBasedOrderStatus(String status) {
		List<Orders> orderDetails = new ArrayList<>();
		if (status != null) {
			orderDetails = orderManagementRepository.findByorderStatus(status);
		}
		return orderDetails;
	}

}
