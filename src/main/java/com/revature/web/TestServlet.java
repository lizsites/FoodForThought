package com.revature.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.LoginController;


public class TestServlet extends HttpServlet {
	private static final LoginController lc = new LoginController();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setStatus(404);
		
		
		final String uri = req.getRequestURI().replace("/JenkinsRepo/", "");
		String[] layeredUri = uri.split("/");
		System.out.println(Arrays.toString(layeredUri));
		
		switch(layeredUri[0]) {
		case "login" :
			if (req.getMethod().equals("POST")) {
			lc.login(req,res);
			} 
		break;
		case  "update":
			if (req.getMethod().equals("POST")) {
				System.out.println("IN USER POST CASE");
				lc.updateUser(req, res);
			} else if (req.getMethod().equals("POST")) {
				//put lc.addUser(req,res) here!
			}
			break;
		case "logout" :
			lc.logout(req,res);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doGet(req, res);
	}
}
