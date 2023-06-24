package com.example.service;

import com.example.entity.UserEntity;

public interface IUserService {
	UserEntity findOneByUsernameAndPassword(UserEntity user);
}
