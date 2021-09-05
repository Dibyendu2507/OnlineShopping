package com.dibyendu.BackendShopping.Cart;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dibyendu.BackendShopping.Entity.Cart;
import com.dibyendu.BackendShopping.Entity.CartLite;
import com.dibyendu.BackendShopping.Entity.Orderhistory;
import com.dibyendu.BackendShopping.Entity.Product;
import com.dibyendu.BackendShopping.Entity.User;
import com.dibyendu.BackendShopping.History.HistoryRepository;
import com.dibyendu.BackendShopping.Product.ProductRepository;
import com.dibyendu.BackendShopping.User.UserRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartrepository;
	
	@Autowired
	private ProductRepository productrepository;
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private HistoryRepository historyrepository;
	
	public List<Cart> getItems(int userId){
		
		List<Cart> Allitems = cartrepository.findAll();
		List<Cart> Useritems = new ArrayList<>();
		
		for(int i=0; i<Allitems.size(); i++){
			if(Allitems.get(i).getUser().getUserid()==userId){
				Useritems.add(Allitems.get(i));
			}
		}
		
		return Useritems;
		
	}
	
	public List<CartLite> getItemsLite(int userId){
		
		List<Cart> Allitems = cartrepository.findAll();
		List<CartLite> Useritemslite = new ArrayList<>();
		
		for(int i=0; i<Allitems.size(); i++){
			if(Allitems.get(i).getUser().getUserid()==userId){
				CartLite itemlite = new CartLite();
				itemlite.setProductid(Allitems.get(i).getProduct().getProductid());
				itemlite.setQuantity(Allitems.get(i).getQuantity());
				Useritemslite.add(itemlite);
			}
		}
		
		Collections.sort(Useritemslite);
		return Useritemslite;
		
	}
	
	public Optional<Cart> getItem(int userId, int cartitemId){
		Cart cart = new Cart();
		List<Cart> CartList = cartrepository.findAll();
		
		return cartrepository.findById(cartitemId);
	}
	
	public Cart saveItem(int userId, int productId){
		
		Cart cart = new Cart();
		
		
		List<Product>products = productrepository.findAll();
		List<User>users = userrepository.findAll();
		Product product = new Product();
		User user = new User();
		
		for(int i=0; i<products.size(); i++){
			if(products.get(i).getProductid()==productId){
				product = products.get(i);
				break;
			}
		}
		
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getUserid()==userId){
				user = users.get(i);
				break;
			}
		}
		
		
		cart.setQuantity(1);
		cart.setProduct(product);
		cart.setUser(user);
		return cartrepository.save(cart);
		
	}
		
	public void deleteItem(int userId, int productId){
		
		List<Cart> CartList = cartrepository.findAll();
		int cartitemid = 0;
		
		for(int i=0; i<CartList.size(); i++){
			if(CartList.get(i).getProduct().getProductid()==productId && CartList.get(i).getUser().getUserid()==userId){
				cartitemid = CartList.get(i).getCartitemId();
				break;
			}
		}
		
		cartrepository.deleteById(cartitemid);
		
	}
	
	public Cart updateItem(int userId, int productId, int quantity){
		
		List<Cart> CartList = cartrepository.findAll();
		int cartitemid = 0;
		Cart cart = new Cart();
		
		for(int i=0; i<CartList.size(); i++){
			if(CartList.get(i).getProduct().getProductid()==productId && CartList.get(i).getUser().getUserid()==userId){
				cartitemid = CartList.get(i).getCartitemId();
				cart = CartList.get(i);
				break;
			}
		}

		cart.setQuantity(quantity);
		cartrepository.deleteById(cartitemid);
		return cartrepository.save(cart);
	}
	
	public void deleteCart(int userId){
		List<Cart> CartList = cartrepository.findAll();
		for(int i=0; i<CartList.size(); i++){
			if (CartList.get(i).getUser().getUserid()==userId){
				cartrepository.delete(CartList.get(i));
			}
		}
		
	}
	
	public void placeOrder(int userId){
		
		List<Cart> CartList = cartrepository.findAll();
		for(int i=0; i<CartList.size(); i++){
			if (CartList.get(i).getUser().getUserid()==userId){
				Orderhistory historyitem = new Orderhistory();
				historyitem.setProduct(CartList.get(i).getProduct());
				historyitem.setQuantity(CartList.get(i).getQuantity());
				historyitem.setUser(CartList.get(i).getUser());
				cartrepository.delete(CartList.get(i));
				historyrepository.save(historyitem);
		
			}
			
		}
		
	}
	
	public void updateUserid(int olduserId, int newuserId){
		
		List<Cart> CartList = cartrepository.findAll();
		
		List<User>users = userrepository.findAll();
		User user = new User();
		
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getUserid()==newuserId){
				user = users.get(i);
				break;
			}
		}

		for(int i=0; i<CartList.size(); i++){
			if (CartList.get(i).getUser().getUserid()==olduserId){
				Cart cart = new Cart();
				cart = CartList.get(i);
				cart.setUser(user);
				cartrepository.delete(CartList.get(i));
				cartrepository.save(cart);
		
			}
			
		}
		
	}
	
}
