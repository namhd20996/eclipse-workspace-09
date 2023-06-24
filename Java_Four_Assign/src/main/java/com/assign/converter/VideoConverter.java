package com.assign.converter;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.assign.dto.VideoDTO;
import com.assign.entity.VideoEntity;

public class VideoConverter {

	private ModelMapper mapper = new ModelMapper();

	public static VideoConverter getInstacne() {
		VideoConverter converter = null;
		if (converter == null) {
			converter = new VideoConverter();
		}
		return converter;
	}

	public VideoDTO toDTO(VideoEntity entity) {
		VideoDTO dto = null;
		if (entity != null) {
			dto = mapper.map(entity, VideoDTO.class);
		}
		return dto;
	}

	public VideoEntity toEntity(VideoDTO dto) {
		VideoEntity entity = null;
		if (dto != null) {
			entity = mapper.map(dto, VideoEntity.class);
		}
		return entity;
	}

	public List<VideoDTO> toListDTO(List<VideoEntity> entities) {
		List<VideoDTO> list = Arrays.asList(mapper.map(entities, VideoDTO[].class));
		return list;
	}

	public List<VideoEntity> toListEntity(List<VideoDTO> dtos) {
		List<VideoEntity> list = Arrays.asList(mapper.map(dtos, VideoEntity[].class));
		return list;
	}
}
