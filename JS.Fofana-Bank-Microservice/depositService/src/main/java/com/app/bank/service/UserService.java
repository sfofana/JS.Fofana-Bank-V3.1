package com.app.bank.service;

import java.util.List;

import com.app.bank.model.User;

public interface UserService {

	public User updateUser(User user);
	public User getUser(int id);
	public User depositTest(int id);
	public List<User> getUsers();
}
