package dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class CatDao implements DAOInterface<Cat> {
	public static CatDao getInstance() {
		return new CatDao();
	}

	@Override
	public boolean insert(Cat t) {
		return saveOrUpdate(t);
	}

	public boolean saveOrUpdate(Cat t) {
		boolean result = false;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				session.saveOrUpdate(t);
				tr.commit();
				session.close();
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public boolean update(Cat t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Cat t) {
		boolean result = false;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				session.delete(t);
				tr.commit();
				session.close();
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public Cat selectById(Cat t) {
		Cat cat = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				String hql = "from Cat c where c.id=:id";
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getId());
				cat = (Cat) query.getSingleResult();
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cat;
	}

	@Override
	public List<Cat> selectAll() {
		List<Cat> list = new ArrayList<>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				// Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL có thể Ko cần cú pháp Select *
				// Và phải viết đúng hoa thường với tên Class đã đặt
				String hql = "from Cat";
				Query query = session.createQuery(hql);
				list = query.getResultList();
				// tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
