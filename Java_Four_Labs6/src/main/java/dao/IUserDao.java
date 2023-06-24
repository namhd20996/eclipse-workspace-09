package dao;

import java.util.List;

import entity.User;

public interface IUserDao {
	User findById(String id);

	List<User> findByVideoId(String id);
}
