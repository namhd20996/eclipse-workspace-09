package com.assign.service;

import java.util.List;

import com.assign.dto.VideoDTO;

public interface IVideoService {
	VideoDTO findOneById(Long id);

	VideoDTO findOneByHref(String href);

	List<VideoDTO> findAll();

	List<VideoDTO> findAll(int pageNumber, int pageSize);

	VideoDTO create(VideoDTO videoDTO);

	VideoDTO update(VideoDTO videoDTO);

	VideoDTO delete(String href);
	
	Integer totalItem();
}
