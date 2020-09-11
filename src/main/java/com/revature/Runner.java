package com.revature;

import org.hibernate.Session;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.models.Diet;
import com.revature.models.User;
import com.revature.utilities.HibernateUtil;

public class Runner {

	public static void main(String[] args) {
		
		User u = new User("betty1","godzilla", 100, 500, Diet.Glutenfree);
		
		UserDAO userDAO = new UserDAOImp();
		
		if (userDAO.addUser(u)) {
			System.out.println("Success!");
			System.out.println(u);
		} else if (userDAO.updateUser(u)) {
			System.out.println("Updated!");
			System.out.println(u);
		} else {
			System.out.println("Failure");
		}
		
	}

}
