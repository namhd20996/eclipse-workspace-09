package com.assign.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.assign.dao.IStatsDao;
import com.assign.dto.VideoLikedInfo;
import com.assign.service.IStatsService;

public class StatsServiceImpl implements IStatsService {

	@Inject
	private IStatsDao statsDao;

	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		return statsDao.findVideoLikedInfo();
	}

}
