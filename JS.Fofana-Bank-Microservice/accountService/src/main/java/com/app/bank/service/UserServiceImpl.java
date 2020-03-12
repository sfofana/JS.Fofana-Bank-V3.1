package com.app.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bank.data.UserData;
import com.app.bank.model.Checking;
import com.app.bank.model.Saving;
import com.app.bank.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserData userData;
	
	@Override
	public User currentAcctInfo(User user, User deposit, User withdraw, User transfer) {
		User current = userData.findById(user.getId()).get();
		User updatedUser = current;
		
		updatedUser.getChecking().setAmount(
				current.getChecking().getAmount()+
				deposit.getChecking().getAmount()+
				withdraw.getChecking().getAmount()+
				transfer.getChecking().getAmount()
				);
		updatedUser.getSaving().setAmount(
				current.getSaving().getAmount()+
				deposit.getSaving().getAmount()+
				withdraw.getSaving().getAmount()+
				transfer.getSaving().getAmount()
				);
		
		return updatedUser;
	}

}
