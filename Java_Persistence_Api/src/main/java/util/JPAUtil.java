package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory;

	public static EntityManager getEntityManager() {
		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("Poly");
		}
		return factory.createEntityManager();
	}

	public static void closeEntityManager() {
		if (factory != null && factory.isOpen()) {
			factory.close();
		}
		factory = null;
	}
}
