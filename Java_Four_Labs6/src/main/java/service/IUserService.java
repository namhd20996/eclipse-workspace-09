package service;

import java.util.List;

import entity.User;

public interface IUserService {
	User findById(String id);

	List<User> findByVideoId(String id);
}
