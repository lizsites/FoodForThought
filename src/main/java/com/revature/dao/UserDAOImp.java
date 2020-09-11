package com.revature.dao;

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
		try {
			tx = sess.beginTransaction();
			sess.save(u);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			sess.close();
		}
		
	}
	@Override
	public boolean updateUser(User u) {
		Session sess = HibernateUtil.getSession();
		Transaction tx;
		try {
			tx = sess.beginTransaction();
			sess.merge(u);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			sess.close();
		}
	}

}
