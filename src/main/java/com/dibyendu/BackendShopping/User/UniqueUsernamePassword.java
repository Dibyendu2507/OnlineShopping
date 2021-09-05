package com.dibyendu.BackendShopping.User;

import org.springframework.beans.factory.annotation.Autowired;

import com.dibyendu.BackendShopping.Entity.User;

public class UniqueUsernamePassword {
	
	String username, password;
	
	@Autowired
	private UserRepository userrepository;
	
	public String validate(User user){
		
		try{
			User user_name = userrepository.findByUsername(user.getUsername());
			//username = user_name.getUsername();
		}catch(Exception e){
			username = null;
		}try{
			User pass_word = userrepository.findByPassword(user.getPassword());
			//password = pass_word.getPassword();
		}catch(Exception e){
			password = null;
		}
		
		if( username == null && password == null ){
			return null;
		}else if(username == null){
			return "Password already taken";
		}else if(password == null){
			return "Username already taken";
		}else{
			return "Username and password both are already taken";
		}
		
	}
	
}
