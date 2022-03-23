package com.example.Authentication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Authentication.entities.User;
import com.example.Authentication.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/")
	public String showForm(ModelMap model) {
		return "index";
	}
	
	@PostMapping("/login")
	public String checkAuthentication(ModelMap model, @RequestParam("email") String email, @RequestParam("password") String password) {
		
		if(!email.isBlank() && !password.isBlank()) {
			User user = userService.getUserByEmail(email);
			logger.info("email is: " + email);
			logger.info("User: " + user.getName());
			if(user.getPassword().equals(password)) {
				model.addAttribute("user", user.getName());
				return "success";
			}
		}
		return "fail";
	}
}
