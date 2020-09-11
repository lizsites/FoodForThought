package com.revature.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.User;
import com.revature.utilities.HibernateUtil;

public class UserDAOImp implements UserDAO {

	@Override
	public boolean addUser(User u) {
		Session sess = HibernateUtil.getSession();
		try {
			sess.save(u);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public boolean updateUser(User u) {
		Session sess = HibernateUtil.getSession();
		try {
			sess.merge(u);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}
