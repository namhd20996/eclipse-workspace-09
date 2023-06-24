package com.assign.dao;

import java.util.List;

import com.assign.entity.HistoryEntity;

public interface IHistoryDao {
	List<HistoryEntity> findByUsername(String username);

	List<HistoryEntity> findByUsernameAndIsLiked(String username);

	HistoryEntity findByUserIdAndVideoId(Long userId, Long videoId);

	HistoryEntity create(HistoryEntity entity);
	
	HistoryEntity update(HistoryEntity entity);
}
