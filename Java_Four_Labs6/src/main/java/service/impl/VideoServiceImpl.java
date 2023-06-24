package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import converter.VideoConverter;
import dao.IVideoDao;
import dto.VideoDTO;
import entity.Video;
import service.IVideoService;

public class VideoServiceImpl implements IVideoService {

	@Inject
	private IVideoDao videoDao;

	@Override
	public List<Video> findByKeyword(String title) {
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", title);
		return videoDao.findByKeyword(map);
	}

	@Override
	public List<Video> findByFavorites(Boolean isFavorite) {
		return videoDao.findByFavorites(isFavorite);
	}

	@Override
	public List<Video> findByNamedQuery(String namedQuery, String id) {
		return videoDao.findByNamedQuery(namedQuery, id);
	}

	@Override
	public List<Video> findByNamedQueryKeyword(String namedQuery, Map<String, Object> params, boolean isdKeyword) {
		return videoDao.findByNamedQueryKeyword(namedQuery, params, isdKeyword);
	}

	@Override
	public List<VideoDTO> findByNativeNameQuery(String namedQuery) {
		return VideoConverter.getInstance().toListVideo(videoDao.findByNativedNameQuery(namedQuery));
	}

}
