package com.dibyendu.BackendShopping.History;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dibyendu.BackendShopping.Cart.CartService;
import com.dibyendu.BackendShopping.Entity.Cart;
import com.dibyendu.BackendShopping.Entity.CartLite;
import com.dibyendu.BackendShopping.Entity.HistoryLite;
import com.dibyendu.BackendShopping.Entity.Orderhistory;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HistoryController {
	
	@Autowired
	private HistoryService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/order/{userId}/getOrders")	
	public List<Orderhistory> getItems(@PathVariable int userId){
		return service.getItems(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/order/{userId}/getOrdersLite")	
	public List<HistoryLite> getItemsLite(@PathVariable int userId){
		return service.getItemsLite(userId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/order/{userId}/deleteHistory")	
	public void deleteHistory(@PathVariable int userId){
		service.deleteHistory(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/order/{olduserId}/updateUserid/{newuserId}")	
	public void updateUserid(@PathVariable int olduserId, @PathVariable int newuserId){
		service.updateUserid(olduserId, newuserId);
	}

}
