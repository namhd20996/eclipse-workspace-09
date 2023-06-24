package com.example.dao;

import com.example.entity.UserEntity;

public interface IUserDao {
	UserEntity findOneByUsernameAndPassword(UserEntity user);
}
