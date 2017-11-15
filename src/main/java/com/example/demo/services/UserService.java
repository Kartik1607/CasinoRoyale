package com.example.demo.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.helper.ResponseModel;
import com.example.demo.models.User;
import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;
import com.querydsl.core.types.Predicate;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ImageService imageService;
	
	
	public ResponseModel<List<UserModel>> findAll() {
		ResponseModel<List<UserModel>> response = new ResponseModel<>();
		List<UserModel> users = new ArrayList<>();
		this.userRepository.findAll().forEach(user -> users.add(user));
		response.setSuccess(true);
		response.setData(users);
		return response;
	}
	
	public ResponseModel<Iterable<UserModel>> findAll(Predicate predicate) {
		ResponseModel<Iterable<UserModel>> response = new ResponseModel<>();
		Iterable<UserModel> users = this.userRepository.findAll(predicate);
		response.setSuccess(true);
		response.setData(users);
		return response;
	}
	
	public ResponseModel<UserModel> saveUser(UserModel user) {
		ResponseModel<UserModel> response = new ResponseModel<>();
		UserModel userResult = this.userRepository.save(user);
		if(userResult != null) {
			response.setSuccess(true);
			response.setData(userResult);
		} else {
			response.setSuccess(false);
			response.setError("Something went wrong");
		}
		return response;
	}
	
	public ResponseModel<UserModel> saveUser(User user) {
		UserModel userModel = user.generateUserModel();
		decorateUserModel(userModel, user);
		return this.saveUser(userModel);
	}
	
	public ResponseModel<UserModel> findById(Integer id) {
		ResponseModel<UserModel> response = new ResponseModel<>();
		UserModel user = this.userRepository.findById(id);
		if(user == null) {
			response.setSuccess(false);
			response.setError("Not found");
		} else {
			response.setSuccess(true);
			response.setData(user);
		}
		return response;
	}
	
	public ResponseModel<UserModel> findByUID(Long uid) {
		ResponseModel<UserModel> response = new ResponseModel<>();
		UserModel user = this.userRepository.findByUid(uid);
		if(user == null) {
			response.setSuccess(false);
			response.setError("Not found");
		} else {
			response.setSuccess(true);
			response.setData(user);
		}
		return response;
	}
	
	@Transactional
	public void addBalance(Long uid, BigDecimal amount) {
		this.userRepository.updateBalance(uid, amount);
	}
	
	@Transactional
	public void deductBalance(Long uid, BigDecimal amount) {
		amount = amount.multiply(new BigDecimal("-1"));
		this.userRepository.updateBalance(uid, amount);
	}
	
	@Transactional
	public void blockAmount(Long uid, BigDecimal amount) {
		this.userRepository.updateBlockingAmount(uid, amount);
	}
	
	@Transactional
	public void unblockAmount(Long uid, BigDecimal amount) {
		this.userRepository.updateBlockingAmount(uid, amount.multiply(new BigDecimal("-1")));
	}
	
	private void decorateUserModel(final UserModel userModel, final User user) {
		ResponseModel<String> res = this.imageService.saveImage(user.getIdProof());
		userModel.setIdProofLocation(res.getData());
		userModel.setBalanceAmount(new BigDecimal("500"));
		userModel.setBlockedAmount(new BigDecimal("0"));
		userModel.setUid(System.currentTimeMillis());
	}

	@Transactional
	public ResponseModel<UserModel> removeBlockingAmount(Long uid, BigDecimal amount) {
		this.userRepository.removeBlockingAmount(uid, amount);
		return this.findByUID(uid);
	}	
	
}
