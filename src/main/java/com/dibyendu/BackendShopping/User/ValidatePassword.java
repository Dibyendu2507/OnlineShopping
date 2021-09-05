package com.dibyendu.BackendShopping.User;

import org.springframework.beans.factory.annotation.Autowired;

import com.dibyendu.BackendShopping.Entity.User;

public class ValidatePassword {
	
	@Autowired
	private UserRepository userrepository;
	private User user;
	
	public String validate(String password){
		user = userrepository.findByPassword(password);
		return user.getPassword();
	}

}
