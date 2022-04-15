package com.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.model.OrderDet;
@Repository
public interface orderRepo extends MongoRepository<OrderDet,Integer> {

	
	boolean save(int id);
}
