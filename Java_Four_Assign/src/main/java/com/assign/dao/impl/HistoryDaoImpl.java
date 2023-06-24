package com.assign.dao.impl;

import java.util.List;

import com.assign.dao.AbstractDao;
import com.assign.dao.IHistoryDao;
import com.assign.entity.HistoryEntity;

public class HistoryDaoImpl extends AbstractDao<HistoryEntity> implements IHistoryDao {

	@Override
	public List<HistoryEntity> findByUsername(String username) {
		String hql = "SELECT o FROM HistoryEntity o WHERE o.user.username = ?0 AND o.user.isActive = 1"
				+ " ORDER BY o.viewDate DESC";
		return findMany(HistoryEntity.class, hql, username);
	}

	@Override
	public List<HistoryEntity> findByUsernameAndIsLiked(String username) {
		String hql = "SELECT o FROM HistoryEntity o WHERE o.isLike = 1 AND o.user.username = ?0 AND o.video.isActive = 1"
				+ " ORDER BY o.viewDate DESC";
		return findMany(HistoryEntity.class, hql, username);
	}

	@Override
	public HistoryEntity findByUserIdAndVideoId(Long userId, Long videoId) {
		String hql = "SELECT o FROM HistoryEntity o WHERE o.user.id = ?0 AND o.video.id = ?1 AND o.video.isActive = 1";
		return findOne(HistoryEntity.class, hql, userId, videoId);
	}

	@Override
	public HistoryEntity create(HistoryEntity entity) {
		return super.create(entity);
	}

	@Override
	public HistoryEntity update(HistoryEntity entity) {
		return super.update(entity);
	}

}
