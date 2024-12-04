package com.foodapp.dao.model;

import java.time.LocalDateTime;

public class User
{
	private int userid;
	private String username;
	private String password;
	private String email;
	private String address;
	private LocalDateTime createddate;
	private LocalDateTime lastlogindate;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDateTime getCreateddate() {
		return createddate;
	}
	public void setCreateddate(LocalDateTime createddate) {
		this.createddate = createddate;
	}
	public LocalDateTime getLastlogindate() {
		return lastlogindate;
	}
	public void setLastlogindate(LocalDateTime lastlogindate) {
		this.lastlogindate = lastlogindate;
	}
	
	public User() {
		super();
	}
	
	public User(int userid, String username, String password, String email, String address, LocalDateTime createddate,
			LocalDateTime lastlogindate) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.createddate = createddate;
		this.lastlogindate = lastlogindate;
	}
	
	@Override
	public String toString() 
	{
		return  userid + "   " + username + "    " + password + "   " + email + "     "
				+ address + "    " + createddate + "    " + lastlogindate;
	}
}