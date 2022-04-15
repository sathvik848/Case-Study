package com.userservice.repo;



import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.userservice.model.Signup;



@Repository
public interface userRepository extends MongoRepository<Signup, Integer>{
	

	

	
	boolean save(int id);

	Signup findByName(String name);

}
