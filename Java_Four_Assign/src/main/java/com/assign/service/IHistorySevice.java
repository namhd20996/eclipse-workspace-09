package com.assign.service;

import java.util.List;

import com.assign.dto.HistoryDTO;
import com.assign.dto.UserDTO;
import com.assign.dto.VideoDTO;

public interface IHistorySevice {
	List<HistoryDTO> findByUsername(String username);

	List<HistoryDTO> findByUsernameAndIsLiked(String username);

	HistoryDTO findByUserIdAndVideoId(Long userId, Long videoId);

	HistoryDTO create(UserDTO userDTO, VideoDTO videoDTO);

	Boolean updateLikeOrUnLike(UserDTO userDTO, String videoHref);
}
