package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;

public class LoginController {
	
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		HttpSession sess = req.getSession();
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);
		ObjectMapper om = new ObjectMapper();
		User u = om.readValue(body, User.class);
		
		if (ls.login(u)) {
			
		}
		
		
	}
}
