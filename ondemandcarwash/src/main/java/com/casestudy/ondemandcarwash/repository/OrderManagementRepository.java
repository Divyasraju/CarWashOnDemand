package com.casestudy.ondemandcarwash.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.ondemandcarwash.model.Orders;

public interface OrderManagementRepository extends MongoRepository<Orders, Long> {

	Orders findByorderId(String orderId);

	List<Orders> findByorderStatus(String orderStatus);

	List<Orders> findByserviceType(String serviceType);

    List<Orders> findByorderDate(Date orderDate);


	

}
