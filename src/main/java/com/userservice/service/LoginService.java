package com.userservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.model.Login;
import com.userservice.model.Signup;
import com.userservice.repo.userRepository;



@Service
public class LoginService {

	@Autowired
	private userRepository repo;

	public String userLogin(Login login) {
		ArrayList<Signup> list = (ArrayList<Signup>) repo.findAll();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUsername().equals(login.getUsername())
					&& list.get(i).getPassword().equals(login.getPassword())) {
				count++;
			}
		}
		if (count == 1) {
			return "logged in";
		} else {
			return "wrong credentials";
		}

	}

}
