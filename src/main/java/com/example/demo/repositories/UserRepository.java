package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer>{
	
}

