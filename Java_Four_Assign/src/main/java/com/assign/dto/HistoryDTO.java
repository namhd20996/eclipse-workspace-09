package com.assign.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class HistoryDTO extends BaseDTO<HistoryDTO> {
	private UserDTO user;
	private VideoDTO video;
	private Timestamp viewDate;
	private Boolean isLike;
	private Timestamp likeDate;
}
