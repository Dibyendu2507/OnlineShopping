package com.dibyendu.BackendShopping.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue
	private Integer cartitemId;
	private Integer quantity;
	//private Integer userid;
	//private Integer productid;
	
	@ManyToOne(targetEntity = User.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JsonBackReference(value = "user-cart")
    private User user;
	
	@ManyToOne(targetEntity = Product.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JsonBackReference(value = "product-cart")
	private Product product;
	
	public Cart() {

	}

	public Integer getCartitemId() {
		return cartitemId;
	}

	public void setCartitemId(Integer cartitemId) {
		this.cartitemId = cartitemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
/*
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}
*/	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	

	
}
