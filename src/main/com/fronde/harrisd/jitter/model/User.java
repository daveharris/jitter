package com.fronde.harrisd.jitter.model;

import java.io.Serializable;

public class User implements Domain, Serializable {
	private static final long serialVersionUID = 6819401897574760273L;
	
	private int id;
	private String screenName;
	private String email;
	private String firstName;
	private String lastName;
	private byte[] avatar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public byte[] getAvatar() {
		return avatar;
	}
}
