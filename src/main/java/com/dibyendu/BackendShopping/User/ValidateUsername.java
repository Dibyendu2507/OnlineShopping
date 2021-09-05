package com.dibyendu.BackendShopping.User;

import org.springframework.beans.factory.annotation.Autowired;

import com.dibyendu.BackendShopping.Entity.User;

public class ValidateUsername {
	
	@Autowired
	private UserRepository userrepository;
	private User user;
	
	public String validate(String username){
		user = userrepository.findByUsername(username);
		return user.getUsername();

	}

}
