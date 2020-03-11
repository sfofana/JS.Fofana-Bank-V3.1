package com.app.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bank.data.UserData;
import com.app.bank.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserData userData;
	
	@Override
	public User authentication(User user) {
		User authenticated = userData.findByEmail(user.getEmail());
		User response = new User();
		if(user.getPassword().equals(authenticated.getPassword())) {
			response = authenticated;
		}
		return response;
	}

}
