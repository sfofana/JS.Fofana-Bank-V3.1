package com.app.bank.service;

import com.app.bank.model.User;

public interface UserService {

	public User getCurrentWithdraws(User user);
	public User updateWithdraw(User user);
}
