package com.example.demo.repositories;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.QUserModel;
import com.example.demo.models.UserModel;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

public interface UserRepository extends CrudRepository<UserModel, Integer>
	, QueryDslPredicateExecutor<UserModel>, QuerydslBinderCustomizer<QUserModel>{

	@Override
	default void customize(QuerydslBindings bindings, QUserModel user) {
		bindings.bind(String.class).first(
			      (StringPath path, String value) -> path.containsIgnoreCase(value));
	}

	
}

