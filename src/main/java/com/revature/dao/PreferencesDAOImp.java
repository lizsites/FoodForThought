package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Preferences;
import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.utilities.HibernateUtil;

public class PreferencesDAOImp implements PreferencesDAO {

	@Override
	public boolean addPreference(Preferences p) {
		Session sess = HibernateUtil.getSession();
		Transaction tx;

		tx = sess.beginTransaction();
		try {
			sess.save(p);
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
	public boolean updatePreference(Preferences p) {
		Session sess = HibernateUtil.getSession();
		Transaction tx;
		tx = sess.beginTransaction();
		try {			
			sess.merge(p);
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
	public Preferences getById(int id) {
		Session sess = HibernateUtil.getSession();
		try {
			return sess.get(Preferences.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Preferences getByUserId(int id) {
		Session sess = HibernateUtil.getSession();
		try {
			return sess.get(Preferences.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersByPreferenceId(int id) {
		Session sess = HibernateUtil.getSession();
		try {
			//not sure if will work
			return sess.createQuery("FROM users WHERE preference_id = "+ id).list();
		}catch (HibernateException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}	
	}
	}
