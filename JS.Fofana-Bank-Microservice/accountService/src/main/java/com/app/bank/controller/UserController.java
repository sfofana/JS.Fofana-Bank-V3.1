package com.app.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.bank.model.User;
import com.app.bank.service.UserService;

@RestController
public class UserController {
	
	private String depositUrl = "http://localhost:9000/deposit-service/api/v1/deposit";
	private String withdrawUrl = "http://localhost:9000/withdraw-service/api/v1/withdraw";
	private String transferUrl = "http://localhost:9000/transfer-service/api/v1/transfer";
	private String testDepositUrl = "http://localhost:9000/deposit-service/test/1";
	
	@Autowired 
	RestTemplate restTemplate;
	@Autowired
	UserService userService;
	
	@PostMapping("/api/v1/account")
	public User accountInfo(@RequestBody User user) {
		HttpEntity<Object> request = new HttpEntity<Object>(user);
		User acctD = restTemplate.postForObject(depositUrl, request, User.class);
		User acctW = restTemplate.postForObject(withdrawUrl, request, User.class);
		User acctT = restTemplate.postForObject(transferUrl, request, User.class);
		
		return userService.currentAcctInfo(user, acctD, acctW, acctT);
	}
	
	@GetMapping("/test")
	public User test() {
		User user = new User();
		user.setId(1);
		User acctD = restTemplate.getForObject(testDepositUrl, User.class);
		
		return userService.currentAcctInfo(user, acctD, acctD, acctD);
	}

}
