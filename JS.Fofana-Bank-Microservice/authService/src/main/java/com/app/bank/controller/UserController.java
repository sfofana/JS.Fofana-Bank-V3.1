package com.app.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bank.model.User;
import com.app.bank.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public User authentication(@RequestBody User user) {
		return userService.authentication(user);
	}
}
