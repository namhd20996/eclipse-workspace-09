package dao.impl;

import java.util.List;

import dao.AbstractDao;
import dao.IUserDao;
import entity.User;

public class UserDaoImpl extends AbstractDao<User> implements IUserDao {

	@Override
	public User findById(String id) {
		return findById(User.class, id);
	}

	@Override
	public List<User> findByVideoId(String id) {
		String sql = "SELECT o.user FROM Favorites o WHERE o.video.id = ?0";
		return findMany(User.class, sql, id);
	}

}
