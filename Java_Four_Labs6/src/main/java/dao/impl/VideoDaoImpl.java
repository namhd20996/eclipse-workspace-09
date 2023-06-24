package dao.impl;

import java.util.List;
import java.util.Map;

import dao.AbstractDao;
import dao.IVideoDao;
import entity.Video;

public class VideoDaoImpl extends AbstractDao<Video> implements IVideoDao {

	@Override
	public List<Video> findByKeyword(Map<String, Object> params) {
		String sql = "SELECT DISTINCT o.video FROM Favorites o WHERE o.video.title LIKE:keyword";
		return findMany(Video.class, sql, params);
	}

	@Override
	public List<Video> findByFavorites(Boolean isFavorite) {
		String sql = "SELECT o FROM Video o WHERE o.favorites IS EMPTY";
		if (isFavorite == Boolean.TRUE) {
			sql = "SELECT o FROM Video o WHERE o.favorites IS NOT EMPTY";
		}
		return findMany(Video.class, sql);
	}

	@Override
	public List<Video> findByNamedQuery(String namedQuery, String id) {
		return findNamedQuery(Video.class, namedQuery, id);
	}

	@Override
	public List<Video> findByNamedQueryKeyword(String namedQuery, Map<String, Object> params, boolean idKeyword) {
		return findNamedQuery(Video.class, namedQuery, params, idKeyword);
	}

	@Override
	public List<Video> findByNativedQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> findByNativedNameQuery(String namedQuery) {
		return findManyByNativeQuery(namedQuery);
	}

}
