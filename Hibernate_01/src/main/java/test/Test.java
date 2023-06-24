package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					Cat cat = new Cat();
					cat.setName("Tom");
					cat.setDateOfBirth(Date.valueOf("2023-10-10"));
					cat.setSex(true);
					session.save(cat);
					transaction.commit();
				} finally {
					session.close();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
