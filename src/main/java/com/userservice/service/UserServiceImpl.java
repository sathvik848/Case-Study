package com.userservice.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;


import java.util.List;
import java.util.Objects;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.userservice.model.DatabaseSequence;
import com.userservice.model.Signup;
import com.userservice.repo.userRepository;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private userRepository repo;
	
	
	
	@Override
	public Signup addUser(Signup signup) {
		return repo.save(signup);
	
	}

	@Override
	public List<Signup> getuser() {
		List<Signup> users=repo.findAll();
		System.out.println("Getting data from DB : " +users);
		return users;
	}

	@Override
	public String Updateuser(Signup update) {
		   repo.save(update);
		    return "user updated";
	}

	@Override
	public String deleteById(Integer id) {
		 repo.deleteById(id); 
		  return "user deleted";
	}

	@Override
	public String deleteUser(Signup user) {
		 repo.delete(user);
		  return "user deleted";
	}

	@Override
	public String deleteUser(Integer id) {
		repo.deleteById(id);
		return  "deleted";
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

