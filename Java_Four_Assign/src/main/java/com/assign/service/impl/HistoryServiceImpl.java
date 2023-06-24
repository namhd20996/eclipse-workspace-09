package com.assign.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.assign.converter.HistoryConverter;
import com.assign.dao.IHistoryDao;
import com.assign.dto.HistoryDTO;
import com.assign.dto.UserDTO;
import com.assign.dto.VideoDTO;
import com.assign.entity.HistoryEntity;
import com.assign.service.IHistorySevice;
import com.assign.service.IVideoService;

public class HistoryServiceImpl implements IHistorySevice {

	@Inject
	private IHistoryDao historyDao;

	@Inject
	private IVideoService videoService;

	@Override
	public List<HistoryDTO> findByUsername(String username) {
		return HistoryConverter.getInstance().toListDTO(historyDao.findByUsername(username));
	}

	@Override
	public List<HistoryDTO> findByUsernameAndIsLiked(String username) {
		return HistoryConverter.getInstance().toListDTO(historyDao.findByUsernameAndIsLiked(username));
	}

	@Override
	public HistoryDTO findByUserIdAndVideoId(Long userId, Long videoId) {
		return HistoryConverter.getInstance().toDTO(historyDao.findByUserIdAndVideoId(userId, videoId));
	}

	@Override
	public HistoryDTO create(UserDTO userDTO, VideoDTO videoDTO) {
		HistoryDTO historyDTO = findByUserIdAndVideoId(userDTO.getId(), videoDTO.getId());
		if (historyDTO == null) {
			historyDTO = new HistoryDTO();
			historyDTO.setUser(userDTO);
			historyDTO.setVideo(videoDTO);
			historyDTO.setIsLike(Boolean.FALSE);
			historyDTO.setViewDate(new Timestamp(System.currentTimeMillis()));
			historyDTO = HistoryConverter.getInstance()
					.toDTO(historyDao.create(HistoryConverter.getInstance().toEntity(historyDTO)));
		}
		return historyDTO;
	}

	@Override
	public Boolean updateLikeOrUnLike(UserDTO userDTO, String videoHref) {
		VideoDTO videoDTO = videoService.findOneByHref(videoHref);
		HistoryDTO existHistory = findByUserIdAndVideoId(userDTO.getId(), videoDTO.getId());
		if (existHistory.getIsLike() == Boolean.FALSE) {
			existHistory.setIsLike(Boolean.TRUE);
			existHistory.setLikeDate(new Timestamp(System.currentTimeMillis()));
		} else {
			existHistory.setIsLike(Boolean.FALSE);
			existHistory.setLikeDate(null);
		}
		HistoryEntity historyEntity = historyDao.update(HistoryConverter.getInstance().toEntity(existHistory));
		return historyEntity != null ? true : false;
	}

}
