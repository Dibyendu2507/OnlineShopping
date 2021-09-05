package com.dibyendu.BackendShopping.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Item {
	@Id
    private int pid;
    private String productName;
    private int qty;
    private int price;
}
