package com.app.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bank.data.CheckingData;
import com.app.bank.data.SavingData;
import com.app.bank.data.UserData;
import com.app.bank.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserData userData;
	@Autowired
	CheckingData checkingData;
	@Autowired
	SavingData savingData;

	@Override
	public User getCurrentDeposits(User user) {
		return userData.findById(user.getId()).get();
	}

	@Override
	public User updateDeposit(User user) {
		checkingData.save(user.getChecking());
		savingData.save(user.getSaving());
		return userData.save(user);
	}

}
