package com.dibyendu.BackendShopping.User;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dibyendu.BackendShopping.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);
	User findByPassword(String password);
}
