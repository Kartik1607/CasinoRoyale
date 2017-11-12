package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	private final String KEY_LOCATION = "location";
	
	@RequestMapping("/")
	public String getHome(Model model) {
		model.addAttribute(KEY_LOCATION, 0);
		return "index";
	}
	
	@GetMapping("/register")
	public String getRegister(Model model) {
		model.addAttribute(KEY_LOCATION, 1);
		return "index";
	}
	
	@GetMapping("/users")
	public String getUsers(Model model) {
		model.addAttribute(KEY_LOCATION, 2);
		return "index";
	}
}
