package com.app.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/test2")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/test/{id}")
	public User test(@PathVariable("id") int id) {
		
		return userService.getUser(id);
	}
	
	@GetMapping("/deposit/{id}")
	public User deposit(@PathVariable("id") int id) {
		
		return userService.depositTest(id);
	}

}
