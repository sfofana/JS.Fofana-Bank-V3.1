package com.app.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bank.data.UserData;
import com.app.bank.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserData userData;
	
	@Override
	public User updateUser(User user) {
		return userData.save(user);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userData.findAll();
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userData.findById(id).get();
	}

	@Override
	public User depositTest(int id) {
		double money = 100.15;
		User user = userData.findById(id).get();
		User update = user;
		update.getChecking().setAmount(user.getChecking().getAmount()+money);
		return userData.save(update);
	}

}
