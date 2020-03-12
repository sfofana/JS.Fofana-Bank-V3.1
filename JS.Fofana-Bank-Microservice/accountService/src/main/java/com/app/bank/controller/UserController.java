package com.app.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.bank.model.User;
import com.app.bank.service.UserService;

@RestController
public class UserController {
	
	private String depositUrl = "http://localhost:9000/deposit-service/test/1";
	
	@Autowired 
	RestTemplate restTemplate;
	@Autowired
	UserService userService;
	
	@PostMapping("/account")
	public User accountInfo(User user) {
		User acctD = restTemplate.getForObject(depositUrl, User.class);
		
		return userService.currentAcctInfo(user, acctD, acctD, acctD);
	}
	
	@GetMapping("/test")
	public User test() {
		User user = new User();
		user.setId(1);
		User acctD = restTemplate.getForObject(depositUrl, User.class);
		
		return userService.currentAcctInfo(user, acctD, acctD, acctD);
	}

}
