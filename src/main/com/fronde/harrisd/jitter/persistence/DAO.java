package com.fronde.harrisd.jitter.persistence;

import java.util.List;

import org.hibernate.Session;

import com.fronde.harrisd.jitter.model.Domain;
import com.fronde.harrisd.jitter.model.Post;
import com.fronde.harrisd.jitter.model.User;

public interface DAO {
	public void save(Domain object);
	public void update(Domain object);
	public void delete(Domain object);
	
	public Post findPostByID(int id);
	public User findUserByID(int id);
	public User findUserByScreenName(String name);
	
	public List findAll(Class clazz);
}
