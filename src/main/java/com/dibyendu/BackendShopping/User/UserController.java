package com.dibyendu.BackendShopping.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dibyendu.BackendShopping.Entity.LoginCredential;
import com.dibyendu.BackendShopping.Entity.User;



@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService service;
	
	private ValidateUsername validateusername;
	private ValidateUsername validatepassword;
	
	private UniqueUsernamePassword UniqueUsernamePassword;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public int LogIn(@RequestBody LoginCredential logincredential){
		try{
			User user = service.LogIn(logincredential);
			int id = user.getUserid();
			return id;
		}catch(Exception e){
			return 0;
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/signup")
	public String addUser(@RequestBody User user){
		
		String username, password;

		try{
			username = service.validateusername(user.getUsername());
		}catch(Exception e){
			username = null;
		}try{
			password = service.validatepassword(user.getPassword());
		}catch(Exception e){
			password = null;
		}
		
		if( username != null && password != null ){
			return "Username and password both are already taken";
		}else if(username != null){
			return "username already taken";
		}else if(password != null){
			return "password already taken";
		}else{
			service.saveUser(user);
			return null;
		}
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getprofile/{userId}")
	public Optional<User> getUser(@PathVariable int userId){
		return service.getUser(userId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update/{userId}")
	public String updateUser(@RequestBody User user, @PathVariable int userId){
		
		String username, password;

		try{
			username = service.validateusername(user.getUsername());
		}catch(Exception e){
			username = null;
		}try{
			password = service.validatepassword(user.getPassword());
		}catch(Exception e){
			password = null;
		}
		
		if( (username != null && password != null) && (service.getUseridByUsername(username) != userId && service.getUseridByPassword(password) != userId) ){
			return "Username and password both are already taken";
		}else if(username != null && service.getUseridByUsername(username) != userId){
			return "username already taken";
		}else if(password != null && service.getUseridByPassword(password) != userId){
			return "password already taken";
		}else{
			service.updateUser(user, userId);
			return "";
		}
		//service.updateUser(user, userId);
	}

}
