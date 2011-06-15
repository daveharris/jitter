package com.fronde.harrisd.jitter.model;

import java.util.List;

public class WebModel {
	private static WebModel instance = null;
	private static final String MODEL_NAME = "model";

	private String message;
	private List<Post> posts;
	private User user;

	private WebModel() {
		// no-op
	}

	public static WebModel getInstance() {
		if (instance == null) {
			instance = new WebModel();
		}
		return instance;
	}

	public String getName() {
		return MODEL_NAME;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
