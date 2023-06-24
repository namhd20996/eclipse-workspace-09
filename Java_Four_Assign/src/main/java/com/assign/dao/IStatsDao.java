package com.assign.dao;

import java.util.List;

import com.assign.dto.VideoLikedInfo;

public interface IStatsDao {

	List<VideoLikedInfo> findVideoLikedInfo();
}
