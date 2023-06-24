package com.assign.converter;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.assign.dto.HistoryDTO;
import com.assign.entity.HistoryEntity;

public class HistoryConverter {

	private ModelMapper mapper = new ModelMapper();

	public static HistoryConverter getInstance() {
		HistoryConverter converter = null;
		if (converter == null) {
			converter = new HistoryConverter();
		}
		return converter;
	}

	public HistoryDTO toDTO(HistoryEntity entity) {
		HistoryDTO dto = null;
		if (entity != null) {
			dto = mapper.map(entity, HistoryDTO.class);
		}
		return dto;
	}

	public HistoryEntity toEntity(HistoryDTO dto) {
		HistoryEntity entity = null;
		if (dto != null) {
			entity = mapper.map(dto, HistoryEntity.class);
		}
		return entity;
	}

	public List<HistoryDTO> toListDTO(List<HistoryEntity> entities) {
		List<HistoryDTO> list = Arrays.asList(mapper.map(entities, HistoryDTO[].class));
		return list;
	}

	public List<HistoryEntity> toListEntity(List<HistoryDTO> dtos) {
		List<HistoryEntity> list = Arrays.asList(mapper.map(dtos, HistoryEntity[].class));
		return list;
	}
}
