package com.example.demo.repositories;


import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.QUserModel;
import com.example.demo.models.UserModel;
import com.querydsl.core.types.dsl.StringPath;

public interface UserRepository extends CrudRepository<UserModel, Integer>
	, QueryDslPredicateExecutor<UserModel>, QuerydslBinderCustomizer<QUserModel>{

	@Override
	default void customize(QuerydslBindings bindings, QUserModel user) {
		bindings.bind(String.class).first(
			      (StringPath path, String value) -> path.containsIgnoreCase(value));
	}

	public UserModel findById(Integer id);
	
	public UserModel findByUid(Long uid);
	
	@Modifying
	@Query("UPDATE UserModel u SET u.balanceAmount = u.balanceAmount + :balanceAmount WHERE u.uid = :uid")
    int updateBalance(@Param("uid") Long uid, @Param("balanceAmount") BigDecimal balanceAmount);

	@Modifying
	@Query("UPDATE UserModel u SET u.blockedAmount = u.blockedAmount + :blockedAmount, u.balanceAmount = u.balanceAmount - :blockedAmount WHERE u.uid = :uid")
    int updateBlockingAmount(@Param("uid") Long uid, @Param("blockedAmount") BigDecimal blockedAmount);
	
	@Modifying
	@Query("UPDATE UserModel u SET u.blockedAmount = u.blockedAmount - :blockedAmount WHERE u.uid = :uid")
	int removeBlockingAmount(@Param("uid") Long uid, @Param("blockedAmount") BigDecimal blockedAmount);

}

