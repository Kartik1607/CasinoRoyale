package com.example.demo.controllers.restApi;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.ResponseModel;
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
	public ResponseEntity<ResponseModel<UserModel>> rechargeUserBalance(
			@PathVariable(value = "userId", required = true) Long userId,
			@RequestParam(value = "amount", required = true) BigDecimal amount) {
		this.userService.addBalance(userId, amount);
		return new ResponseEntity<ResponseModel<UserModel>>( 
				this.userService.findByUID(userId), HttpStatus.OK);
	}
	
	@PutMapping("/deduct/{userId}")
	public ResponseEntity<ResponseModel<UserModel>> deductUserBalance(
			@PathVariable(value = "userId", required = true) Long userId,
			@RequestParam(value = "amount", required = true) BigDecimal amount) {
		this.userService.deductBalance(userId, amount);
		return new ResponseEntity<ResponseModel<UserModel>>(
				this.userService.findByUID(userId), HttpStatus.OK);
	}
	
	@PutMapping("/blockAmount/{userId}")
	public ResponseEntity<ResponseModel<UserModel>> blockUserBalance(
			@PathVariable(value = "userId", required = true) Long userId,
			@RequestParam(value = "amount", required = true) BigDecimal amount) {
		this.userService.blockAmount(userId, amount);
		return new ResponseEntity<ResponseModel<UserModel>>(
				this.userService.findByUID(userId), HttpStatus.OK);
	}
	
	@PutMapping("/unBlockAmount/{userId}")
	public ResponseEntity<ResponseModel<UserModel>> unBlockUserBalance(
			@PathVariable(value = "userId", required = true) Long userId,
			@RequestParam(value = "amount", required = true) BigDecimal amount) {
		this.userService.unblockAmount(userId, amount);
		return new ResponseEntity<ResponseModel<UserModel>>(
				this.userService.findByUID(userId), HttpStatus.OK);
	}
	
	@PutMapping("/removeBlockedAmount/{userId}")
	public ResponseEntity<ResponseModel<UserModel>> removeBlockedUserBalance(
			@PathVariable(value = "userId", required = true) Long userId,
			@RequestParam(value = "amount", required = true) BigDecimal amount) {
		this.userService.removeBlockingAmount(userId, amount);
		return new ResponseEntity<ResponseModel<UserModel>>(
				this.userService.findByUID(userId), HttpStatus.OK);
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<ResponseModel<Iterable<UserModel>>> getUsers(@QuerydslPredicate(root = UserModel.class) Predicate predicate) {
		return new ResponseEntity<ResponseModel<Iterable<UserModel>>>(
				this.userService.findAll(predicate), HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<ResponseModel<UserModel>> getUser(@PathVariable(value="userId", required=true) Long userId) {
		return new ResponseEntity<ResponseModel<UserModel>>(
				this.userService.findByUID(userId), HttpStatus.OK);
	}
}
