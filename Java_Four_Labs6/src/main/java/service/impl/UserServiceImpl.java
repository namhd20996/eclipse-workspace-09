package service.impl;

import java.util.List;

import javax.inject.Inject;

import dao.IUserDao;
import entity.User;
import service.IUserService;

public class UserServiceImpl implements IUserService {

	@Inject
	private IUserDao userDao;

	@Override
	public User findById(String id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> findByVideoId(String id) {
		return userDao.findByVideoId(id);
	}

}
