package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Preferences;
import com.revature.models.Steps;

@Repository
@Transactional
public class StepsDAOImp implements StepsDAO{

private SessionFactory sf;
	
	@Autowired
	public StepsDAOImp(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	@Override
	public boolean addStep(Steps p) {
		Session sess = sf.getCurrentSession();
		if(p!=null) {
			sess.save(p);
			return true;
		}else
			return false;
		
	}
	

}
