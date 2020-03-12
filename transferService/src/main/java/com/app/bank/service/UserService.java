package com.app.bank.service;

import com.app.bank.model.User;

public interface UserService {
	
	public User getCurrentTransfers(User user);
	public User updateTransfer(User user);
}
