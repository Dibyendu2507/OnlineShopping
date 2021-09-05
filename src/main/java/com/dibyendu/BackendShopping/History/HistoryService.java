package com.dibyendu.BackendShopping.History;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dibyendu.BackendShopping.Entity.Cart;
import com.dibyendu.BackendShopping.Entity.CartLite;
import com.dibyendu.BackendShopping.Entity.HistoryLite;
import com.dibyendu.BackendShopping.Entity.Orderhistory;
import com.dibyendu.BackendShopping.Entity.User;
import com.dibyendu.BackendShopping.User.UserRepository;

@Service
public class HistoryService {
	
	@Autowired
	private HistoryRepository historyrepository;
	
	@Autowired
	private UserRepository userrepository;
	
	public List<Orderhistory> getItems(int userId){
		
		List<Orderhistory> Allitems = historyrepository.findAll();
		List<Orderhistory> Useritems = new ArrayList<>();
		
		for(int i=0; i<Allitems.size(); i++){
			if(Allitems.get(i).getUser().getUserid()==userId){
				Useritems.add(Allitems.get(i));
			}
		}
		
		return Useritems;
		
	}
	
	public List<HistoryLite> getItemsLite(int userId){
		
		List<Orderhistory> Allitems = historyrepository.findAll();
		List<HistoryLite> Useritemslite = new ArrayList<>();
		
		for(int i=0; i<Allitems.size(); i++){
			if(Allitems.get(i).getUser().getUserid()==userId){
				HistoryLite itemlite = new HistoryLite();
				itemlite.setProductid(Allitems.get(i).getProduct().getProductid());
				itemlite.setQuantity(Allitems.get(i).getQuantity());
				Useritemslite.add(itemlite);
			}
		}
		
		Collections.sort(Useritemslite);
		return Useritemslite;
		
	}
	
	public void deleteHistory(int userId){
		List<Orderhistory> HistoryList = historyrepository.findAll();
		for(int i=0; i<HistoryList.size(); i++){
			if (HistoryList.get(i).getUser().getUserid()==userId){
				historyrepository.delete(HistoryList.get(i));
			}
		}
	}
	
	public void updateUserid(int olduserId, int newuserId){
		
		List<Orderhistory> HistoryList = historyrepository.findAll();
		
		List<User>users = userrepository.findAll();
		User user = new User();
		
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getUserid()==newuserId){
				user = users.get(i);
				break;
			}
		}

		for(int i=0; i<HistoryList.size(); i++){
			if (HistoryList.get(i).getUser().getUserid()==olduserId){
				Orderhistory historyitem = new Orderhistory();
				historyitem = HistoryList.get(i);
				historyitem.setUser(user);
				historyrepository.delete(HistoryList.get(i));
				historyrepository.save(historyitem);
		
			}
			
		}
		
	}

}
