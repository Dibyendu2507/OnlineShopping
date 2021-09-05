package com.dibyendu.BackendShopping.Product;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.dibyendu.BackendShopping.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	
	
}
