package com.fronde.harrisd.twitter.persistence;

import java.util.List;

import org.hibernate.Session;

import com.fronde.harrisd.twitter.model.Domain;
import com.fronde.harrisd.twitter.model.Post;
import com.fronde.harrisd.twitter.model.User;

public interface DAO {
	public void save(Domain object);
	public void update(Domain object);
	public void delete(Domain object);
	
	public Post findPostByID(int id);
	public User findUserByID(int id);
	public User findUserByScreenName(String name);
	
	public List findAll(Class clazz);
}
