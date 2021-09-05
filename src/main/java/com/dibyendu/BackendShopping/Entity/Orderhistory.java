package com.dibyendu.BackendShopping.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Orderhistory {
	
	@Id
	@GeneratedValue
	private Integer historyitemId;
	private Integer quantity;
	//private Integer userid;
	//private Integer productid;
	
	@ManyToOne(targetEntity = User.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JsonBackReference(value = "user-history")
    private User user;
	
	@ManyToOne(targetEntity = Product.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JsonBackReference(value = "product-history")
	private Product product;
	
	public Orderhistory() {

	}

	public Integer getHistoryitemId() {
		return historyitemId;
	}

	public void setHistoryitemId(Integer historyitemId) {
		this.historyitemId = historyitemId;
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
