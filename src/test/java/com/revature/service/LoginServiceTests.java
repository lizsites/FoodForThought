package com.revature.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.User;
import com.revature.services.LoginService;

public class LoginServiceTests {
	
	public static LoginService ls = new LoginService();
	public static User u = new User();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		u.setUsername("betty1");
		u.setPassword("destroyah");
	}

	@Test
	public void testLogin() {
		System.out.println("Testing login");
		assertTrue(ls.login(u));
		System.out.println("Login test successful");
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

}
