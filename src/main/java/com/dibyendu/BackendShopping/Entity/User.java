package com.dibyendu.BackendShopping.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer userid;
	private String name;
	private String mail;
	private String username;
	private String password;
	private Long contact;
	private String dob;
	
	@OneToOne(targetEntity = Address.class,cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "user-cart")
    private List<Cart> cartlist = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "user-history")
    private List<Orderhistory> historylist = new ArrayList<>();

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
