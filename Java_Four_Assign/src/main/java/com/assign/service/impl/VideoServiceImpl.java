package com.assign.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.assign.converter.VideoConverter;
import com.assign.dao.IVideoDao;
import com.assign.dto.VideoDTO;
import com.assign.entity.VideoEntity;
import com.assign.service.IVideoService;

@SuppressWarnings("unused")
public class VideoServiceImpl implements IVideoService {

	@Inject
	private IVideoDao videoDao;

	@Override
	public VideoDTO findOneById(Long id) {
		return VideoConverter.getInstacne().toDTO(videoDao.findOneById(id));
	}

	@Override
	public VideoDTO findOneByHref(String href) {
		return VideoConverter.getInstacne().toDTO(videoDao.findOneByHref(href));
	}

	@Override
	public List<VideoDTO> findAll() {
		return VideoConverter.getInstacne().toListDTO(videoDao.findAll());
	}

	@Override
	public List<VideoDTO> findAll(int pageNumber, int pageSize) {
		return VideoConverter.getInstacne().toListDTO(videoDao.findAll(pageNumber, pageSize));
	}

	@Override
	public VideoDTO create(VideoDTO videoDTO) {
		videoDTO.setIsActive(Boolean.TRUE);
		videoDTO.setViews(0);
		videoDTO.setShares(0);
		return VideoConverter.getInstacne().toDTO(videoDao.create(VideoConverter.getInstacne().toEntity(videoDTO)));
	}

	@Override
	public VideoDTO update(VideoDTO videoDTO) {
		return VideoConverter.getInstacne().toDTO(videoDao.update(VideoConverter.getInstacne().toEntity(videoDTO)));
	}

	@Override
	public VideoDTO delete(String href) {
		VideoDTO dto = findOneByHref(href);
		dto.setIsActive(Boolean.FALSE);
		return VideoConverter.getInstacne().toDTO(videoDao.update(VideoConverter.getInstacne().toEntity(dto)));
	}

	@Override
	public Integer totalItem() {
		return videoDao.totalItem();
	}

}
