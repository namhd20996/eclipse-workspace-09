package com.assign.dto;

import lombok.Data;

@Data
public class VideoLikedInfo {
	private Integer videoId;
	private String title;
	private String href;
	private Integer totalLike;
}
