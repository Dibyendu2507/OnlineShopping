package com.dibyendu.BackendShopping.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Product {
	
	@Id
	private Integer productid;
	private String name;
	private String productcategory;
	private String imgsrc;
	private Integer rating;
	private Integer price;
	private String gender;
	private String details;
	
	@OneToMany(mappedBy = "product")
    @JsonManagedReference(value = "product-cart")
    private List<Cart> cartlist = new ArrayList<>();
	
	@OneToMany(mappedBy = "product")
    @JsonManagedReference(value = "product-history")
    private List<Orderhistory> historylist = new ArrayList<>();
	
	public Product() {
		
	}

	public Integer getProductid() {
		return productid;
	}


	public void setProductid(Integer productid) {
		this.productid = productid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getProductcategory() {
		return productcategory;
	}


	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}


	public String getImgsrc() {
		return imgsrc;
	}


	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}
	
	


	public List<Cart> getCartlist() {
		return cartlist;
	}


	public void setCartlist(List<Cart> cartlist) {
		this.cartlist = cartlist;
	}


	public List<Orderhistory> getHistorylist() {
		return historylist;
	}


	public void setHistorylist(List<Orderhistory> historylist) {
		this.historylist = historylist;
	}



}
