package com.assign.service;

import java.util.List;

import com.assign.dto.VideoLikedInfo;

public interface IStatsService {
	
	List<VideoLikedInfo> findVideoLikedInfo();
}
