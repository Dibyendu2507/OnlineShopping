package com.dibyendu.BackendShopping.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dibyendu.BackendShopping.Entity.LoginCredential;
import com.dibyendu.BackendShopping.Entity.Product;
import com.dibyendu.BackendShopping.Entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	
	private UniqueUsernamePassword UniqueUsernamePassword;
	
	public void saveUser(User user){
		userrepository.save(user);
	}
	
	public String validateusername(String username){
		User user = userrepository.findByUsername(username);
		return user.getUsername();
	}
	
	public String validatepassword(String password){
		User user = userrepository.findByPassword(password);
		return user.getPassword();
	}
	
	public int getUseridByUsername(String username){
		User user = userrepository.findByUsername(username);
		return user.getUserid();
	}
	
	public int getUseridByPassword(String password){
		User user = userrepository.findByPassword(password);
		return user.getUserid();
	}
	
	public User LogIn(LoginCredential logincredential){
		
		User username = userrepository.findByUsername(logincredential.getUsername());
		User password = userrepository.findByPassword(logincredential.getPassword());
		if(username.getUserid()==password.getUserid()){
			return password;
		}
		else{
			return null;
		}
		
	}
	
	public Optional<User> getUser(int id){
		return userrepository.findById(id);
	}
	
	public void updateUser(User user, int userid){	
		userrepository.deleteById(userid);
		userrepository.save(user);
	}

}
