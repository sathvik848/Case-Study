package com.orderservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orderservice.model.OrderDet;





@Service
public interface OrderService {

	
	
	public List<OrderDet> details();
	
   public void addOrder(OrderDet order);
   
	

	  
}
