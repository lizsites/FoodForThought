package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.utilities.HibernateUtil;

public class UserDAOImp implements UserDAO {

	@Override
	public boolean addUser(User u) {
		Session sess = HibernateUtil.getSession();
		Transaction tx;

		tx = sess.beginTransaction();
		try {
			sess.save(u);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			sess.close();
		}
		
	}
	@Override
	public boolean updateUser(User u) {
		Session sess = HibernateUtil.getSession();
		Transaction tx;
		tx = sess.beginTransaction();
		try {
			
			sess.merge(u);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			sess.close();
		}
	}
	
	@Override
	public User getUserById(int id) {
		Session sess = HibernateUtil.getSession();
		try {
			return sess.get(User.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUsername(String username) {
		Session sess = HibernateUtil.getSession();
		try {
			List<User> u;
			u = sess.createQuery("FROM users WHERE username = '"+username + "'").list();
			return u.get(0);
		}catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

}
