package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.Video;
import util.HibernateUtil;

@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
public class AbstractDao<T> {

	public static final Session SESSION = HibernateUtil.getSession();

	@Override
	protected void finalize() throws Throwable {
		SESSION.clear();
		super.finalize();
	}

	public T findById(Class<T> clazz, Object params) {
		return SESSION.find(clazz, params);
	}

	public List<T> findAll(Class<T> clazz, boolean existIsActive) {
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");
		if (existIsActive) {
			sql.append(" WHERE isActive =1");
		}
		Query<T> query = SESSION.createQuery(sql.toString(), clazz);
		return query.getResultList();
	}

	public List<T> findAll(Class<T> clazz, boolean existIsActive, int pageNumber, int pageSize) {
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");
		if (existIsActive) {
			sql.append(" WHERE isActive = 1");
		}
		Query<T> query = SESSION.createQuery(sql.toString(), clazz);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	public T findOne(Class<T> clazz, String sql, Object... params) {
		Query<T> query = SESSION.createQuery(sql, clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<T> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	public List<T> findMany(Class<T> clazz, String sql, Object... params) {
		Query<T> query = SESSION.createQuery(sql, clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}

	public List<T> findMany(Class<T> clazz, String sql, Map<String, Object> params) {
		Query<T> query = SESSION.createQuery(sql);
		params.forEach((key, value) -> query.setParameter(key, "%" + value + "%"));
		return query.getResultList();
	}

	public List<Object[]> findManyByNativeQuery(Class<T> clazz, String sql, Object... params) {
		Query query = SESSION.createNativeQuery(sql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}

	public List<Object[]> findManyByNativeQuery(String namedNative, Object... params) {
		Query query = SESSION.createNamedQuery(namedNative);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}

	public T create(T entity) {
		try {
			SESSION.getTransaction().begin();
			SESSION.persist(entity);
			SESSION.getTransaction().commit();
			System.out.println("Create success");
			return entity;
		} catch (Exception e) {
			SESSION.getTransaction().rollback();
			System.out.println("Cannot insert entity " + entity.getClass().getSimpleName());
			throw new RuntimeException(e);
		}
	}

	public T update(T entity) {
		try {
			SESSION.getTransaction().begin();
			SESSION.merge(entity);
			SESSION.getTransaction().commit();
			System.out.println("Create success");
			return entity;
		} catch (Exception e) {
			SESSION.getTransaction().rollback();
			System.out.println("Cannot insert entity " + entity.getClass().getSimpleName());
			throw new RuntimeException(e);
		}
	}

	public T delete(T entity) {
		try {
			SESSION.getTransaction().begin();
			SESSION.remove(entity);
			SESSION.getTransaction().commit();
			System.out.println("Create success");
			return entity;
		} catch (Exception e) {
			SESSION.getTransaction().rollback();
			System.out.println("Cannot insert entity " + entity.getClass().getSimpleName());
			throw new RuntimeException(e);
		}
	}

	public List<Object[]> callStored(String namedStored, Map<String, Object> params) {
		StoredProcedureQuery query = SESSION.createNamedStoredProcedureQuery(namedStored);
		params.forEach((key, value) -> query.setParameter(key, value));
		return query.getResultList();
	}

	public List<T> findNamedQuery(Class<T> clazz, String namedQuery, Map<String, Object> params, boolean isKeyword) {
		Query<T> query = SESSION.createNamedQuery(namedQuery, clazz);
		params.forEach((key, value) -> query.setParameter(key, value));
		if (isKeyword) {
			params.forEach((key, value) -> query.setParameter(key, "%" + value + "%"));
		}
		return query.getResultList();
	}

	public List<T> findNamedQuery(Class<T> clazz, String namedQuery, Object... params) {
		Query<T> query = SESSION.createNamedQuery(namedQuery, clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}


	public static void main(String[] args) {
		AbstractDao<Video> a = new AbstractDao<>();
		Map<String, Object> map = new HashMap<>();
		map.put("year", 2023);
		List<Object[]> list = a.callStored("Report.favoriteByYear", map);
		for (Object[] objects : list) {
			System.out.println(objects[3]);
		}
	}

}
