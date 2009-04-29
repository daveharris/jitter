package com.fronde.harrisd.twitter.persistence;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.annotation.Rollback;

import com.fronde.harrisd.twitter.model.User;

public class TestUser extends AbstractDependencyInjectionSpringContextTests {
	
	private User user = new User();

	// Setter injected by Spring
	private HibernateDAO dao;
	
	public TestUser() {
		buildUser();
	}

	public void setDao(HibernateDAO dao) {
		this.dao = dao;
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:application-context.xml" };
	}

	/*
	 * Build a default user
	 */
	public void buildUser() {
		user.setScreenName("Test");
		user.setFirstName("Test");
		user.setLastName("Tester");
		user.setEmail("test.tester@fronde.com");
	}
	

	@Test
	@Ignore
	public void testSaveUser() {
		dao.save(user);
		
		assertEquals(user, dao.findUserByID(user.getId()));
	}
	

	@Ignore
	@Test
	public void testUpdateUser() {
		final String NEW_FIRST_NAME = "FIRST NAME";
		final String NEW_LAST_NAME = "LAST NAME";
		
		user.setFirstName(NEW_FIRST_NAME);
		user.setLastName(NEW_LAST_NAME);
		dao.update(user);
		
		assertEquals(NEW_FIRST_NAME, dao.findUserByID(user.getId()).getFirstName());
		assertEquals(NEW_LAST_NAME, dao.findUserByID(user.getId()).getLastName());
	}

	
	@Ignore
	@Test
	public void testDeleteUser() {
		dao.save(user);
		int id = user.getId();
		dao.delete(user);
		
		assertEquals(null, dao.findUserByID(id));
	}

	
	@Ignore
	@Test
	public void testFindUserById() {
		dao.save(user);
		User newUser = dao.findUserByID(user.getId());
		assertEquals(newUser, user);
	}
	
	@Ignore
	@Test
	public void testFindUserByScreenName() {
		dao.save(user);
		User newUser = dao.findUserByScreenName(user.getScreenName());
		assertEquals(newUser.getScreenName(), user.getScreenName());
	}

	@SuppressWarnings("unchecked")
	@Test
	@Ignore
	public void testFindAll() {
//		int count = countRowsInTable("User");
//		List<User> list = dao.findAll(User.class);
//		assertEquals(count, list.size());
	}
}