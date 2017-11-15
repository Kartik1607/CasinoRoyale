package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.helper.Constants;
import com.example.demo.helper.ResponseModel;
import com.example.demo.models.User;
import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService UserService;
	
	@GetMapping("/register")
	public String getRegister(Model model) {
		model.addAttribute(Constants.KEY_LOCATION, Constants.LOCATION_REGISTRATION);
		model.addAttribute("user", new User());
		return "index";
	}
	
	@PostMapping("/register")
	public String test(@ModelAttribute User user, Model model) {
		ResponseModel<UserModel> response = this.UserService.saveUser(user);
		UserModel userModel = response.getData();
		
		model.addAttribute(Constants.KEY_LOCATION, Constants.LOCATION_REGISTRATION);
		model.addAttribute("UID", userModel.getUid());
		model.addAttribute("success", true);
		return "index";
	}
	
}
