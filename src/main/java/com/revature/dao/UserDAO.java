package com.revature.dao;

import com.revature.models.User;

public interface UserDAO {
	public boolean addUser(User u);
	public boolean updateUser(User u);
	public User getUserById(int id);
}
