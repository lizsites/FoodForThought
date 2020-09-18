package com.revature;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

import org.hibernate.Session;

import com.revature.dao.PreferencesDAO;
import com.revature.dao.PreferencesDAOImp;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.models.Preferences;
import com.revature.models.Preferences.DietType;
import com.revature.models.User;
import com.revature.utilities.HibernateUtil;

public class Runner {

	public static void main(String[] args) {
		
		
		UserDAO userDAO = new UserDAOImp();
		PreferencesDAO prefDAO= new PreferencesDAOImp();
		
//		System.out.println(userDAO.getUserByUsername("betty1"));
		
		
		User user1= new User("livray", hash("soccer"), null, null, new Preferences (DietType.GLUTEN_FREE, 0, 100));
		userDAO.addUser(user1);
		System.out.println(user1);
		System.out.println(user1);
	
}
	//password hashing for when creating users in java
	private static String hash(String pass) {
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");

			byte[] hashByte = md.digest(pass.getBytes(StandardCharsets.UTF_8));
			String myHash = DatatypeConverter.printHexBinary(hashByte);
			return (myHash);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;

	}

}

