package com.example.dao.impl;

import com.example.dao.AbstractDao;
import com.example.dao.IUserDao;
import com.example.entity.UserEntity;

public class UserDaoImpl extends AbstractDao<UserEntity> implements IUserDao {

	@Override
	public UserEntity findOneByUsernameAndPassword(UserEntity user) {
		String sql = "SELECT o FROM UserEntity o WHERE o.id=?0 AND o.password=?1";
		return findOne(UserEntity.class, sql, user.getId(), user.getPassword());
	}

}
