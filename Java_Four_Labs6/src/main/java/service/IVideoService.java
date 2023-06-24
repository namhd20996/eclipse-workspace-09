package service;

import java.util.List;
import java.util.Map;

import dto.VideoDTO;
import entity.Video;

public interface IVideoService {
	List<Video> findByKeyword(String title);

	List<Video> findByFavorites(Boolean isFavorite);

	List<Video> findByNamedQuery(String namedQuery, String id);

	List<Video> findByNamedQueryKeyword(String namedQuery, Map<String, Object> params, boolean idKeyword);
	
	List<VideoDTO> findByNativeNameQuery(String namedQuery);
}
