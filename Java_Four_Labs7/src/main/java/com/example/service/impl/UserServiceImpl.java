package com.example.service.impl;

import javax.inject.Inject;

import com.example.dao.IUserDao;
import com.example.entity.UserEntity;
import com.example.service.IUserService;

public class UserServiceImpl implements IUserService {

	@SuppressWarnings("unused")
	@Inject
	private IUserDao userDao;

	@Override
	public UserEntity findOneByUsernameAndPassword(UserEntity user) {
		return userDao.findOneByUsernameAndPassword(user);
	}

}
