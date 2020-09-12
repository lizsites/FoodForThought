package com.revature;

import org.hibernate.Session;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.models.Diet;
import com.revature.models.User;
import com.revature.utilities.HibernateUtil;

public class Runner {

	public static void main(String[] args) {
		
		
		
		UserDAO userDAO = new UserDAOImp();
		System.out.println(userDAO.getUserByUsername("betty1"));

}
}
