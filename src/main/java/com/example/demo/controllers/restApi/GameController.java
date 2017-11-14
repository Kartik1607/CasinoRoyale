package com.example.demo.controllers.restApi;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;
import com.querydsl.core.types.Predicate;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class GameController {
	
	@Autowired
	private UserService userService;

	@PutMapping("/recharge/{userId}")
	public UserModel rechargeUserBalance(
			@PathVariable(value = "userId", required = true) Long userId,
			@RequestParam(value = "amount", required = true) BigDecimal amount) {
		this.userService.addBalance(userId, amount);
		return this.userService.findByUID(userId);
	}
	
	@PutMapping("/deduct/{userId}")
	public UserModel deductUserBalance(
			@PathVariable(value = "userId", required = true) Long userId,
			@RequestParam(value = "amount", required = true) BigDecimal amount) {
		this.userService.deductBalance(userId, amount);
		return this.userService.findByUID(userId);
	}
	
	@PutMapping("/blockAmount/{userId}")
	public UserModel blockUserBalance(
			@PathVariable(value = "userId", required = true) Long userId,
			@RequestParam(value = "amount", required = true) BigDecimal amount) {
		this.userService.blockAmount(userId, amount);
		return this.userService.findByUID(userId);
	}
	
	@PutMapping("/unBlockAmount/{userId}")
	public UserModel unBlockUserBalance(
			@PathVariable(value = "userId", required = true) Long userId,
			@RequestParam(value = "amount", required = true) BigDecimal amount) {
		this.userService.unblockAmount(userId, amount);
		return this.userService.findByUID(userId);
	}
	
	@GetMapping("/users")
	public Iterable<UserModel> getUsers(@QuerydslPredicate(root = UserModel.class) Predicate predicate) {
		return this.userService.findAll(predicate);
	}
	
	@GetMapping("/users/{userId}")
	public UserModel getUser(@PathVariable(value="userId", required=true) Long userId) {
		return this.userService.findByUID(userId);
	}
}