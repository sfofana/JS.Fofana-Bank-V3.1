package com.app.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bank.model.User;
import com.app.bank.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PutMapping("/deposit")
	public User deposit(User user) {
		return userService.updateUser(user);
	}

}
