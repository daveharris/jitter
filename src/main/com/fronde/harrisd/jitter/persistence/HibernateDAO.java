package com.fronde.harrisd.jitter.persistence;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fronde.harrisd.jitter.model.Domain;
import com.fronde.harrisd.jitter.model.Post;
import com.fronde.harrisd.jitter.model.User;

public class HibernateDAO extends HibernateDaoSupport implements DAO {

//	/**
//	 * Creates a new Hibernate DAO.
//	 * 
//	 * @param sessionFactory
//	 *          the Hibernate session factory
//	 */
//	public HibernateDAO(SessionFactory sessionFactory) {
//			this.sessionFactory = sessionFactory;
//	}

//	protected HibernateDAO() {
//		//needed for aop cglib
//	}

	public void save(Domain object) {
		getHibernateTemplate().saveOrUpdate(object);
	}

	public void update(Domain object) {
		getHibernateTemplate().update(object);
	}

	public void delete(Domain object) {
		getHibernateTemplate().delete(object);
	}

	public Post findPostByID(int id) {
		return (Post) getHibernateTemplate().get(Post.class, id);
	}

	public User findUserByID(int id) {
		return (User) getHibernateTemplate().get(User.class, id);
	}

	public User findUserByScreenName(String name) {
		return (User) getHibernateTemplate().find("from User u where u.screenName = ?", name).get(0);
	}

		
		/*Query query = getHibernateTemplate(). createQuery(
				"from User u where u.screenName = :name");
		query.setString("name", name);
		if (query.list().size() == 1) {
			return (User) query.list().get(0);
		}
		return null;
	}*/

	@SuppressWarnings("unchecked")
	public List<Domain> findAll(Class clazz) {
		//return getHibernateTemplate().loadAll(clazz);
		//Query query = getHibernateTemplate().createQuery();
		//return query.list();
		//getSessionFactory().getCurrentSession().beginTransaction();
		return getSessionFactory().getCurrentSession().createQuery("from " + clazz.getName()).list();
	}
}