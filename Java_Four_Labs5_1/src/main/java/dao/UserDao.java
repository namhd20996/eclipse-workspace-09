package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.User;
import util.HibernateUtil;

public class UserDao implements DAOInterface<User> {
	public static UserDao getInstance() {
		return new UserDao();
	}

	@Override
	public boolean insert(User t) {
		return saveOrUpdate(t);
	}

	private boolean saveOrUpdate(User t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				session.saveOrUpdate(t);
				tr.commit();
				session.close();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(User t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(User t) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tr = session.beginTransaction();
			session.delete(t);
			tr.commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User selectById(User t) {
		User u = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				String hql = "from User o where o.id=:id";
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getId());
				u = (User) query.getSingleResult();
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<User> selectAll() {
		List<User> list = new ArrayList();
		try {
			Session session = HibernateUtil.getSession();
			Transaction tr = session.beginTransaction();
			String hql = "from User";
			Query query = session.createQuery(hql);
			list = query.getResultList();
			tr.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<User> selectByRole(User t) {
		List<User> list = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				String hql = "from User o where o.admin=:admin";
				Query query = session.createQuery(hql);
				query.setParameter("admin", t.getAdmin());
				list = query.getResultList();
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<User> selectByKeyord(String t) {
		List<User> list = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				String hql = "from User o where o.fullname like :keyword";
				Query query = session.createQuery(hql);
				query.setParameter("keyword", t + "%");
				list = query.getResultList();
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public User selectFindOne(User t) {
		User u = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				String hql = "from User o where o.id=:id and o.password=:password";
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getId());
				query.setParameter("password", t.getPassword());
				u = (User) query.getSingleResult();
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return u;
	}

	public List<User> selectFindPage(int page, int size) {
		List<User> list = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				String hql = "from User";
				Query query = session.createQuery(hql);
				query.setFirstResult(page);
				query.setMaxResults(size);
				list = query.getResultList();
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}
