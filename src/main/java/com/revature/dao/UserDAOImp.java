package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository
@Transactional
public class UserDAOImp implements UserDAO {

	private SessionFactory sf;
	
	@Autowired
	public UserDAOImp(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	@Override
	public boolean addUser(User u) {
		Session sess = sf.getCurrentSession();
		if(u!=null) {
			sess.save(u);
			return true;
		}else
			return false;
		
	}
	@Override
	public boolean updateUser(User u) {
		Session sess = sf.getCurrentSession();
		if(u!=null) {
			sess.update(u);
			return true;
		}else
			return false;		
	}
	
	@Override
	public User getUserById(int id) {
		Session sess = sf.getCurrentSession();
		return sess.get(User.class, id);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUsername(String username) {
		Session sess = sf.getCurrentSession();
		Query<User> q = sess.createQuery("FROM user WHERE user.username = :un");
		q.setParameter("un", username);
		return q.getSingleResult();
	}

}
