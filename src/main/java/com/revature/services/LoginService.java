package com.revature.services;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.models.User;

public class LoginService {
	
	public boolean login(User u) {
		UserDAO userDAO = new UserDAOImp();
		User f = userDAO.getUserByUsername(u.getUsername());
		if (f.getPassword().equals(u.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
}
