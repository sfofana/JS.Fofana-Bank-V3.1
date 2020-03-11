package com.app.bank.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.model.User;

@Repository
public interface UserData extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email);
}
