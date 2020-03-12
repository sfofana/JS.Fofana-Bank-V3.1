package com.app.bank.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.bank.data.UserData;
import com.app.bank.model.User;

public class UserServiceImpl implements UserService{

	@Autowired
	UserData userData;
	
	@Override
	public User getCurrentTransfers(User user) {
		return userData.findById(user.getId()).get();
	}

	@Override
	public User updateTransfer(User user) {
		return userData.save(user);
	}

}
