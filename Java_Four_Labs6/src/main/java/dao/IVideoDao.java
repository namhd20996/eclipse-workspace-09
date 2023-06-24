package dao;

import java.util.List;
import java.util.Map;

import entity.Video;

public interface IVideoDao {
	List<Video> findByKeyword(Map<String, Object> params);

	List<Video> findByFavorites(Boolean isFavorite);

	List<Video> findByNamedQuery(String namedQuery, String id);

	List<Video> findByNamedQueryKeyword(String namedQuery, Map<String, Object> params, boolean idKeyword);
	
	List<Video> findByNativedQuery();
	
	List<Object[]> findByNativedNameQuery(String namedQuery);
}
