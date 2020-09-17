package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Preferences;
import com.revature.models.User;

@Repository
@Transactional
public class PreferencesDAOImp implements PreferencesDAO {

	private SessionFactory sf;
	
	@Autowired
	public PreferencesDAOImp(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	@Override
	public boolean addPreference(Preferences p) {
		Session sess = sf.getCurrentSession();
		if(p!=null) {
			sess.save(p);
			return true;
		}else
			return false;
		
	}

	@Override
	public boolean updatePreference(Preferences p) {
		Session sess = sf.getCurrentSession();
		if(p!=null) {
			sess.update(p);
			return true;
		}else
			return false;
		
	}

	@Override
	public Preferences getById(int id) {
		Session sess = sf.getCurrentSession();
		return sess.get(Preferences.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Preferences getByUserId(int id) {
		Session sess = sf.getCurrentSession();
		Query<Preferences> q = sess.createQuery("FROM preferences WHERE user.id = :id");
		q.setParameter("id", id);
		return q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersByPreferenceId(int id) {		
		//updated for spring, but should maybe remove?
		Session sess = sf.getCurrentSession();
		Query<User> q = sess.createQuery("FROM users WHERE preference.id = :id");
		q.setParameter("id", id);
		return q.list();
	}
	}
