package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;

import com.revature.models.User;

import com.revature.services.LoginService;

public class LoginController {
	
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		ObjectMapper om = new ObjectMapper();
		LoginService ls = new LoginService();
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);
		User u = om.readValue(body, User.class);

		if (ls.login(u)) {
			UserDAO userDAO = new UserDAOImp();
			HttpSession sesh = req.getSession();
			sesh.setAttribute("user", u);
			sesh.setAttribute("loggedin" , true);
			res.getWriter().println("login successful");
			res.setStatus(200);
			
	}
}
}
