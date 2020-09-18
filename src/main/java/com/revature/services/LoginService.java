package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.models.User;

@Service
public class LoginService {
	
	private UserDAO uDao;
	
	//inject user dao
	@Autowired
	public LoginService(UserDAO uDao) {
		super();
		this.uDao = uDao;
		
	}
	public boolean login(User u) {
		//check password
		User f = uDao.getUserByUsername(u.getUsername());
		return(f.getPassword().equals(u.getPassword()));
	}
	
	public User getUser(String username) {
		return uDao.getUserByUsername(username);
	}
	
	public boolean updateUser(User u) {
		return uDao.updateUser(u);
	}

	public boolean register(User u) {
		return uDao.addUser(u);
	}
}
