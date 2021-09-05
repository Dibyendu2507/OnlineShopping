package com.dibyendu.BackendShopping.Entity;

public class CartLite implements Comparable<CartLite>{
	
	public Integer productid;
	public Integer quantity;
	
	
	public CartLite() {
		
	}
	
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int compareTo(CartLite cartlite) {
		if (getProductid() == null || cartlite.getProductid() == null) {
		      return 0;
		}
		return getProductid().compareTo(cartlite.getProductid());
	}
	
	

}
