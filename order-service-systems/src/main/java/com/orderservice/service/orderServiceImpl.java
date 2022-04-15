package com.orderservice.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orderservice.model.DatabaseSequence;
import com.orderservice.model.OrderDet;
import com.orderservice.repository.orderRepo;


@Service
public class orderServiceImpl implements OrderService {

	@Autowired
	private orderRepo repo;

	

	@Override
	public void addOrder(OrderDet order) {
		// TODO Auto-generated method stub
		repo.save(order);
	}

	








	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);;
	}









	@Override
	public List<OrderDet> details() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}






	  @Autowired
	  private MongoOperations mongoOperations;



	  public Long getSequenceNumber(String sequenceName) {
	  //get sequence no
	  Query query = new Query(Criteria.where("id").is(sequenceName));
	  //update the sequence no
	  Update update = new Update().inc("seq", 1);
	  //modify in document
	  DatabaseSequence counter = mongoOperations.findAndModify(query,
	  update, options().returnNew(true).upsert(true),
	  DatabaseSequence.class);



	  return !Objects.isNull(counter) ? counter.getSeq() : 1;



	  }






	




	



	

	
}
