package com.assign.dao;

import java.util.List;
import java.util.Map;

import com.assign.entity.UserEntity;

public interface IUserDao {
	UserEntity findOneById(Long id);

	UserEntity findOnedByEmail(String email);

	UserEntity findOneByUsername(String username);
	
	UserEntity findOneByUsernameAndEmail(String username, String email);
	
	Boolean updateUserByUsernameAndVerify(String password, String username, String verify);
	
	UserEntity findOneByUsernameAndPassword(String username, String password);
	
	List<Object[]> findUsersLikedVideoByVideoHref(Map<String, Object> params);

	List<UserEntity> findAll();
	
	List<UserEntity> findAll(int pageNumber, int pageSize);

	UserEntity create(UserEntity entity);

	UserEntity update(UserEntity entity);
}
