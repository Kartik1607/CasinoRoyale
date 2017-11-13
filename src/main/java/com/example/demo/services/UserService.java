package com.example.demo.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.ImageService.Response;
import com.querydsl.core.types.Predicate;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ImageService imageService;
	
	public List<UserModel> findAll() {
		List<UserModel> users = new ArrayList<>();
		this.userRepository.findAll().forEach(user -> users.add(user));
		return users;
	}
	
	public  Iterable<UserModel> findAll(Predicate predicate) {
		return this.userRepository.findAll(predicate);
	}
	
	public UserModel saveUser(UserModel user) {
		return this.userRepository.save(user);
	}
	
	public UserModel saveUser(User user) {
		UserModel userModel = user.generateUserModel();
		decorateUserModel(userModel, user);
		return this.saveUser(userModel);
	}
	
	private void decorateUserModel(final UserModel userModel, final User user) {
		Response<String> res = this.imageService.saveImage(user.getIdProof());
		userModel.setIdProofLocation(res.data);
		userModel.setBalanceAmount(new BigDecimal("500"));
		userModel.setBlockedAmount(new BigDecimal("0"));
		userModel.setUID(System.currentTimeMillis());
	}
	
}
