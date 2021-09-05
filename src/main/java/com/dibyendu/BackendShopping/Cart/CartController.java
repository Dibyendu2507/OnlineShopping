package com.dibyendu.BackendShopping.Cart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dibyendu.BackendShopping.Entity.Cart;
import com.dibyendu.BackendShopping.Entity.CartLite;
import com.dibyendu.BackendShopping.Entity.Product;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {
	
	@Autowired
	private CartService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cart/{userId}/getCart")	
	public List<Cart> getItems(@PathVariable int userId){
		return service.getItems(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cart/{userId}/getCartLite")	
	public List<CartLite> getItemsLite(@PathVariable int userId){
		return service.getItemsLite(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cart/{userId}/getCartItem/{cartitemId}")	
	public Optional<Cart> getItem(@PathVariable int userId, @PathVariable int cartitemId){
		return service.getItem(userId, cartitemId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cart/{userId}/add/{productId}")	
	public Cart addItem(@PathVariable int userId, @PathVariable int productId){
		return service.saveItem(userId, productId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/cart/{userId}/remove/{productId}")	
	public void deleteItem(@PathVariable int userId, @PathVariable int productId){
		service.deleteItem(userId, productId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/cart/{userId}/changeQuantity/{productId}")
	public Cart updateItem(@PathVariable int userId, @PathVariable int productId, @RequestBody int quantity){
		return service.updateItem(userId, productId, quantity);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/cart/{userId}/deleteCart")
	public void deleteCart(@PathVariable int userId){
		service.deleteCart(userId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/cart/{userId}/placeOrder")
	public void placeOrder(@PathVariable int userId){
		service.placeOrder(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cart/{olduserId}/updateUserid/{newuserId}")	
	public void updateUserid(@PathVariable int olduserId, @PathVariable int newuserId){
		service.updateUserid(olduserId, newuserId);
	}
	
}
