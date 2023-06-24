package com.assign.converter;

import java.util.Arrays;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assign.dto.UserDTO;
import com.assign.entity.UserEntity;

@Component
public class UserConverter {
	@Autowired
	private ModelMapper mapper;

	public UserEntity toEntity(UserDTO dto) {
		UserEntity entity = null;
		if (dto != null) {
			entity = mapper.map(dto, UserEntity.class);
		}
		return entity;
	}

	public UserDTO toDTO(UserEntity entity) {
		UserDTO dto = null;
		if (entity != null) {
			dto = mapper.map(entity, UserDTO.class);
		}
		return dto;
	}

	public List<UserDTO> toListDto(List<UserEntity> entities) {
		List<UserDTO> dtos = Arrays.asList(mapper.map(entities, UserDTO[].class));
		return dtos;
	}

	public List<UserEntity> toListEntity(List<UserDTO> dtos) {
		List<UserEntity> entities = Arrays.asList(mapper.map(dtos, UserEntity[].class));
		return entities;
	}
}
