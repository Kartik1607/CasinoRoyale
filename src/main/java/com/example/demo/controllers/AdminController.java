package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.helper.Constants;

@Controller
public class AdminController {
	
	@RequestMapping("/")
	public String getHome(Model model) {
		model.addAttribute(Constants.KEY_LOCATION, Constants.LOCATION_HOME);
		return "index";
	}
	
	
}
