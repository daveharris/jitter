package com.fronde.harrisd.twitter.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post implements Domain, Serializable {
	private static final long serialVersionUID = -4478846819261189062L;
	
	private int id;
	private User author;
	private String body;
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDateString() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM K.mm a");
		return sdf.format(date);
	}
}
