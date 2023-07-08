package com.assign.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
