package com.assign.converter;

import java.util.ArrayList;
import java.util.List;

import com.assign.dto.VideoLikedInfo;

public class StatsConverter {

	public static StatsConverter getInstance() {
		StatsConverter converter = null;
		if (converter == null) {
			converter = new StatsConverter();
		}
		return converter;
	}

	public List<VideoLikedInfo> toListVideoInfo(List<Object[]> objects) {
		List<VideoLikedInfo> result = new ArrayList<>();
		objects.forEach(object -> {
			VideoLikedInfo video = new VideoLikedInfo();
			video.setVideoId(Integer.valueOf(object[0] + ""));
			video.setTitle(String.valueOf(object[1]));
			video.setHref(String.valueOf(object[2]));
			video.setTotalLike(object[3] != null ? Integer.valueOf(object[3] + "") : 0);
			result.add(video);
		});
		return result;
	}
}
