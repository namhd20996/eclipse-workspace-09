package com.assign.dto;

import java.util.List;

import lombok.Data;

@Data
public class VideoDTO extends BaseDTO<VideoDTO> {
	private String title;
	private String href;
	private String poster;
	private Integer views;
	private Integer shares;
	private String description;
	private Boolean isActive;
	private List<HistoryDTO> historyEntities;
}
