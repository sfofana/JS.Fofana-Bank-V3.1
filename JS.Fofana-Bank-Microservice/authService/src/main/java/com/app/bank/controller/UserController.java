package com.app.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bank.model.User;
import com.app.bank.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/api/v1/connection")
	public String connect() {
		return "Successfully connected";
	}
	
	@PostMapping("/api/v1/login")
	public User authentication(@RequestBody User user) {
		System.out.println(user.getEmail());
		return userService.authentication(user);
	}
}
