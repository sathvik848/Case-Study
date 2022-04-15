package com.orderservice.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.exception.ApiRequestException;
import com.orderservice.model.OrderDet;
import com.orderservice.repository.orderRepo;
import com.orderservice.service.orderServiceImpl;


import io.swagger.annotations.ApiOperation;



@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/od")
public class OrderController {

		
		
		@Autowired
		private orderServiceImpl service;
		
		
		@Autowired
		private orderRepo repo;
		
		 @PostMapping("/addorder") 
		 @ApiOperation(value="To add order")
		  public String addOrder(@RequestBody OrderDet order) {
			 order.setOrderId(service.getSequenceNumber(OrderDet.SEQUENCE_NAME));
			  service.addOrder(order); 
			 
			  return "order placed with washer and will be processed soon" +order; }
		 
		 
		 @GetMapping("/allorders")
		 @ApiOperation(value="To get List of all orders")
		 public List<OrderDet> getorder() {
		 return service.details();
		 }
		 
		
		 @DeleteMapping("/cancelorder")
		 @ApiOperation(value="To cancel order")
		 public ResponseEntity<Object> deletorder(@RequestParam int id)
		 {
			 boolean isOrderExist=repo.existsById(id);
			 if(isOrderExist) {
				 service.deleteById(id);
				 return new ResponseEntity<Object>("Order deleted with id "+id,HttpStatus.OK);
			 }
			 else
			 {
				 throw new ApiRequestException("CAN NOT DELETE ORDER,AS ORDER NOT FOUND WITH THIS ID ::");
			 }
		 }
	}

