package com.app.bank.service;

import com.app.bank.model.User;

public interface UserService {
	
	public User getCurrentDeposits(User user);
	public User updateDeposit(User user);
}
