package com.fronde.harrisd.jitter.persistence;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.AbstractSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.fronde.harrisd.jitter.model.Post;
import com.fronde.harrisd.jitter.model.User;

@ContextConfiguration
public class TestPost extends AbstractSpringContextTests {
	
	private Post post = new Post();
	private User user;

	// Setter injected by Spring
	private HibernateDAO dao;
	
	public TestPost() {
		super();
		//buildPost();
	}

	public void setDao(HibernateDAO dao) {
		this.dao = dao;
	}

//	@Override
//	protected String[] getConfigLocations() {
//		return new String[] { "classpath:application-context.xml" };
//	}

	/*
	 * Build a default post
	 */
	private void buildPost() {
		if(dao != null) {
			user = new User();
			user.setScreenName("Test");
			user.setFirstName("Test");
			user.setLastName("Tester");
			user.setEmail("test.tester@fronde.com");
			dao.save(user);
			
			post.setAuthor(user);
			post.setBody("BODY MESSAGE");
			post.setDate(new Date());
		}
	}

	@Test
	public void testSavePost() {
		User newUser = new User();
		newUser.setScreenName("Test");
		newUser.setFirstName("Test");
		newUser.setLastName("Tester");
		newUser.setEmail("test.tester@fronde.com");
		dao.save(newUser);
	
		Post newPost = new Post();
		newPost.setAuthor(newUser);
		newPost.setBody("BODY MESSAGE");
		newPost.setDate(new Date());
		
		dao.save(newPost);
		
		assertEquals(newPost, dao.findPostByID(newPost.getId()));
	}

	@Override
	protected ConfigurableApplicationContext loadContext(Object arg0)
			throws Exception {
		String[] locations = new String[] { "classpath:application-context.xml" };
		return new ClassPathXmlApplicationContext(locations);
	}
	
//
//	@Ignore
//	@Test
//	public void testUpdatePostBody() {
//		final String NEW_BODY = "UPDATED BODY";
//		
//		post.setBody(NEW_BODY);
//		dao.update(post);
//		
//		assertEquals(NEW_BODY, dao.findPostByID(post.getId()).getBody());
//	}
//
//	
//	@Ignore
//	@Test
//	public void testDeletePost() {
//		dao.save(post);
//		int id = post.getId();
//		dao.delete(post);
//		
//		assertEquals(null, dao.findPostByID(id));
//	}
//
//	
//	@Ignore
//	@Test
//	public void testFindPostById() {
//		dao.save(post);
//		Post newPost = dao.findPostByID(post.getId());
//		assertEquals(newPost, post);
//	}
//
//	@Test
//	@Ignore
//	public void testFindAll() {
////		int count = countRowsInTable("Post");
////		List<Post> list = dao.findAll(Post.class);
////		assertEquals(count, list.size());
//	}
}