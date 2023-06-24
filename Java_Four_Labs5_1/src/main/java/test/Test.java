package test;

import java.util.List;

import dao.UserDao;
import model.User;

public class Test {
	public static void main(String[] args) {
		User u = new User();
		u.setId("duynam");
		u.setPassword("1243");
		System.out.println(UserDao.getInstance().selectFindOne(u));
	}
}
