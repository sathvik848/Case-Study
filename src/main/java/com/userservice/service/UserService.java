package com.userservice.service;

import java.util.List;



import com.userservice.model.Signup;



public interface UserService {

	
	  public Signup addUser(Signup signup);
	  public List<Signup> getuser();
      public String Updateuser(Signup update);
	  public String deleteById(Integer id);
	  public String deleteUser(Signup user);
	  public String deleteUser(Integer id);
	public Long getSequenceNumber(String sequenceName);

	
	
	
}

