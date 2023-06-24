package com.assign.dao;

import java.util.List;

import com.assign.entity.VideoEntity;

public interface IVideoDao {

	VideoEntity findOneById(Long id);

	VideoEntity findOneByHref(String href);

	List<VideoEntity> findAll();

	List<VideoEntity> findAll(int pageNumber, int pageSize);
	
	Integer totalItem();

	VideoEntity create(VideoEntity entity);

	VideoEntity update(VideoEntity entity);

	VideoEntity delete(VideoEntity entity);
}
