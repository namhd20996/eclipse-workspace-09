package com.assign.dao.impl;

import java.util.List;
import java.util.Map;

import com.assign.constant.SystemConstant;
import com.assign.dao.AbstractDao;
import com.assign.dao.IUserDao;
import com.assign.entity.UserEntity;

public class UserDaoImpl extends AbstractDao<UserEntity> implements IUserDao {

	@Override
	public UserEntity findOneById(Long id) {
		return findById(UserEntity.class, id);
	}

	@Override
	public UserEntity findOnedByEmail(String email) {
		String hql = "SELECT o FROM UserEntiry o WHERE o.email=?0";
		return findOne(UserEntity.class, hql, email);
	}

	@Override
	public UserEntity findOneByUsername(String username) {
		String hql = "SELECT o FROM UserEntity o WHERE o.username=?0";
		return findOne(UserEntity.class, hql, username);
	}

	@Override
	public UserEntity findOneByUsernameAndPassword(String username, String password) {
		String hql = "SELECT o FROM UserEntity o WHERE o.username=?0 AND o.password=?1";
		return findOne(UserEntity.class, hql, username, password);
	}

	@Override
	public List<UserEntity> findAll() {
		return findAll(UserEntity.class, true);
	}

	@Override
	public UserEntity create(UserEntity entity) {
		return super.create(entity);
	}

	@Override
	public UserEntity update(UserEntity entity) {
		return super.update(entity);
	}

	@Override
	public List<UserEntity> findAll(int pageNumber, int pageSize) {
		return findAll(UserEntity.class, true, pageNumber, pageSize);
	}

	@Override
	public UserEntity findOneByUsernameAndEmail(String username, String email) {
		String hql = "SELECT o FROM UserEntity o WHERE o.username = 0 AND o.email = ?1";
		return findOne(UserEntity.class, hql, username, email);
	}

	@Override
	public Boolean updateUserByUsernameAndVerify(String password, String username, String verify) {
		String hql = "UPDATE UserEntity o SET o.password=?0 WHERE o.username = ?1 AND o.verify = ?2";
		return updateOne(UserEntity.class, hql, password, username, verify);
	}

	@Override
	public List<Object[]> findUsersLikedVideoByVideoHref(Map<String, Object> params) {
		return callStored(SystemConstant.STORE_FIND_USER_BY_HREF, params);
	}

}
