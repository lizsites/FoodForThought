package com.revature;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.PreferencesDAO;
import com.revature.dao.PreferencesDAOImp;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.models.Ingredient;
import com.revature.models.Picture;
import com.revature.models.Preferences;
import com.revature.models.Preferences.DietType;
import com.revature.models.Recipe;
import com.revature.models.RecipeIngredient;
import com.revature.models.Steps;
import com.revature.models.User;
import com.revature.utilities.HibernateUtil;

public class Runner {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO userDAO = ac.getBean(UserDAO.class);
		PreferencesDAO prefDAO = ac.getBean(PreferencesDAO.class);
		
		List<Recipe> userList = new ArrayList<Recipe>();
		Recipe water = new Recipe("water",0,"water recipe", null, null, null);
		List<Steps> waterStep = new ArrayList<Steps>();
		Steps step = new Steps("add water",1,water);
		waterStep.add(step);
		userList.add(water);
		water.setRecipeStep(waterStep);
		User user1= new User("livray", hash("soccer"), userList, new ArrayList<Picture>(), new Preferences (DietType.GLUTEN_FREE, 0, 100));
		user1.setRecipes(userList);
		userDAO.addUser(user1);
		System.out.println(user1);
		
//		public Recipe(String body, int cals, String title, List<RecipeIngredient> recipeIngredient, User owner,
//				List<Steps> step)
//		
//		public Ingredient(int id, String name, int cals, List<RecipeIngredient> recipeIngredient)
//		
//		public RecipeIngredient(Recipe recipe, Ingredient ingredient, String amount)
//		
//		public Steps(String body, int order, Recipe recipe)
		
		
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

