package com.dibyendu.BackendShopping.History;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dibyendu.BackendShopping.Entity.Cart;
import com.dibyendu.BackendShopping.Entity.Orderhistory;

public interface HistoryRepository extends JpaRepository<Orderhistory, Integer>{
	
	//List<Cart> findByUserId(int userId);

}