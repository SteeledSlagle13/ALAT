package com.apexlegendsat.springmvc.view;

public class UserView {
	
	private String username;
	private String email;
	private String address;
	
	public UserView () {
		
	}
	
	public UserView (String username, String email, String address) {
		super();
		this.username = username;
		this.email = email;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "UserView [username=" + username + ", email=" + email + ", address=" + address + "]";
	}
	
}
