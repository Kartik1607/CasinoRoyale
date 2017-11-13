package com.example.demo.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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
	
	public UserModel findById(Integer id) {
		return this.userRepository.findById(id);
	}
	
	public UserModel findByUID(Long uid) {
		return this.userRepository.findByUid(uid);
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
	private void addBlockingAmount(Long uid, BigDecimal amount) {
		this.userRepository.updateBlockingAmount(uid, amount);
	}
	
	@Transactional
	private void removeBlockingAmount(Long uid, BigDecimal amount) {
		this.userRepository.updateBlockingAmount(uid, amount.multiply(new BigDecimal("-1")));
	}
	
	@Transactional
	public void blockAmount(Long uid, BigDecimal amount) {
		this.deductBalance(uid, amount);
		addBlockingAmount(uid, amount);
	}
	
	@Transactional
	public void unblockAmount(Long uid, BigDecimal amount) {
		this.addBalance(uid, amount);
		removeBlockingAmount(uid, amount);
	}
	
	private void decorateUserModel(final UserModel userModel, final User user) {
		Response<String> res = this.imageService.saveImage(user.getIdProof());
		userModel.setIdProofLocation(res.data);
		userModel.setBalanceAmount(new BigDecimal("500"));
		userModel.setBlockedAmount(new BigDecimal("0"));
		userModel.setUid(System.currentTimeMillis());
	}
	
	
}
