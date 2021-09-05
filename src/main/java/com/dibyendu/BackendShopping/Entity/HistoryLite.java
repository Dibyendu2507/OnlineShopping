package com.dibyendu.BackendShopping.Entity;

public class HistoryLite implements Comparable<HistoryLite>{
	
	public Integer productid;
	public Integer quantity;
	
	
	public HistoryLite() {
		
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
	public int compareTo(HistoryLite historylite) {
		if (getProductid() == null || historylite.getProductid() == null) {
		      return 0;
		}
		return getProductid().compareTo(historylite.getProductid());
	}
	
	

}

