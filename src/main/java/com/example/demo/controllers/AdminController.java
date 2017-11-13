package com.example.demo.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.User;
import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;
import com.querydsl.core.types.Predicate;

@Controller
public class AdminController {
	
	private final String KEY_LOCATION = "location";

	@Autowired
	UserRepository userRepo;
	
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
		UserModel userModel = user.generateUserModel();
		userModel.setIdProofLocation(user.getIdProof().getOriginalFilename());
		userModel.setBalanceAmount(new BigDecimal("500"));
		userModel.setBlockedAmount(new BigDecimal("0"));
		userModel.setUID(System.currentTimeMillis());
		this.userRepo.save(userModel);
		model.addAttribute(KEY_LOCATION, 1);
		model.addAttribute("UID", userModel.getUID());
		model.addAttribute("success", true);
		return "index";
	}
	
	@GetMapping("/users")
	public String getUsers(Model model) {
		List<UserModel> users = new ArrayList<>();;
		this.userRepo.findAll().forEach(user -> users.add(user));
		model.addAttribute(KEY_LOCATION, 2);
		model.addAttribute("users", users);
		return "index";
	}
	
	@GetMapping("/search")
	public String doSearch( Model model,
			 @QuerydslPredicate(root = UserModel.class) Predicate predicate) {
		model.addAttribute(KEY_LOCATION, 2);
		model.addAttribute("users", this.userRepo.findAll(predicate));
		return "index";
	}
	
}
