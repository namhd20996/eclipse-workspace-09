package com.assign.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDTO extends BaseDTO<HistoryDTO> {
	private UserDTO user;
	private VideoDTO video;
	private Timestamp viewDate;
	private Boolean isLike;
	private Timestamp likeDate;
}
