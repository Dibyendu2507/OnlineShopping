package com.dibyendu.BackendShopping.Cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dibyendu.BackendShopping.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	//List<Cart> findByUserId(int userId);

}
