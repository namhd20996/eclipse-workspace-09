package com.assign.dao.impl;

import java.util.List;

import com.assign.dao.AbstractDao;
import com.assign.dao.IVideoDao;
import com.assign.entity.VideoEntity;

public class VideoDaoImpl extends AbstractDao<VideoEntity> implements IVideoDao {

	@Override
	public VideoEntity findOneById(Long id) {
		return findById(VideoEntity.class, id);
	}

	@Override
	public VideoEntity findOneByHref(String href) {
		String hql = "SELECT o FROM VideoEntity o WHERE o.href=?0";
		return findOne(VideoEntity.class, hql, href);
	}

	@Override
	public List<VideoEntity> findAll() {
		return findAll(VideoEntity.class, true);
	}

	@Override
	public List<VideoEntity> findAll(int pageNumber, int pageSize) {
		return findAll(VideoEntity.class, true, pageNumber, pageSize);
	}

	@Override
	public VideoEntity create(VideoEntity entity) {
		return super.create(entity);
	}

	@Override
	public VideoEntity update(VideoEntity entity) {
		return super.update(entity);
	}

	@Override
	public VideoEntity delete(VideoEntity entity) {
		return super.delete(entity);
	}

	@Override
	public Integer totalItem() {
		Integer result = findAll().size();
		return result;
	}

}
