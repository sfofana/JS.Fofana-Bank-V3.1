package com.app.bank.service;

import com.app.bank.model.User;

public interface UserService {

	public User currentAcctInfo(User user, User deposit, User withdraw, User transfer);
}
