package util;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutDow() {
		getSessionFactory().close();
	}
}
