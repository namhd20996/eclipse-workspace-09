package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class TestCat2 {
	public static void main(String[] args) {
		// Transient
		Cat cat = new Cat("Teo", new Date(System.currentTimeMillis()), true);
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				Transaction tr =session.beginTransaction();
				// Persistent
				session.save(cat);
				tr.commit();
				// Detached => Persisten
				// refresh giúp khi đã lưu trữ đối tượng xuống CSDL rồi và gọi refresh nó sẽ cập nhật lại đối tượng đó lên lại Persistent
				// 
				session.refresh(cat);
				session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(cat);
	}
}
