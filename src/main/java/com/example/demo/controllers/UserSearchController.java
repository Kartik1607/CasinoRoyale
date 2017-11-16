package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.helper.Constants;
import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;
import com.querydsl.core.types.Predicate;

@Controller
public class UserSearchController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String getUsers(Model model) {
		model.addAttribute(Constants.KEY_LOCATION, Constants.LOCATION_USERS);
		model.addAttribute("users", this.userService.findAll().getData());
		return "index";
	}
	
	@GetMapping("/search")
	public String doSearch( Model model,
			 @QuerydslPredicate(root = UserModel.class) Predicate predicate) {
		
		model.addAttribute(Constants.KEY_LOCATION, Constants.LOCATION_USERS);
		model.addAttribute("users", this.userService.findAll(predicate).getData());
		
		return "index";
	}
	
}
