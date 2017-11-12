package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.User;

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
		model.addAttribute("user", new User());
		return "index";
	}
	
	@PostMapping("/register")
	public String test(@ModelAttribute User user, Model model) {
		System.out.println(user.getName());
		System.out.println(user.getDateOfBirth());
		System.out.println(user.getContactNumber());
		System.out.println(user.getEmailAddress());
		System.out.println(user.getIdProof().getOriginalFilename());
		model.addAttribute(KEY_LOCATION, 1);
		return "index";
	}
	
	@GetMapping("/users")
	public String getUsers(Model model) {
		model.addAttribute(KEY_LOCATION, 2);
		return "index";
	}
}
