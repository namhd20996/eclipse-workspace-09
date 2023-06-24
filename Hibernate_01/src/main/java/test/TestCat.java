package test;

import java.sql.Date;
import java.util.List;

import dao.CatDao;
import model.Cat;

public class TestCat {
	public static void main(String[] args) {
		Cat cat = new Cat( "Meoo", new Date(1010, 10, 10), true);
		cat.setId(4);
		CatDao.getInstance().delete(cat);
	}
}
