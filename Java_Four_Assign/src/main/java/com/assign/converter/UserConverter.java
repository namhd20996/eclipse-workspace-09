package com.assign.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.assign.dto.UserDTO;
import com.assign.entity.UserEntity;

public class UserConverter {

	private ModelMapper mapper = new ModelMapper();

	public static UserConverter getInstance() {
		UserConverter converter = null;
		if (converter == null) {
			converter = new UserConverter();
		}
		return converter;
	}

	public UserDTO toDTO(UserEntity entity) {
		UserDTO dto = null;
		if (entity != null) {
			dto = mapper.map(entity, UserDTO.class);
		}
		return dto;
	}

	@SuppressWarnings("unused")
	public UserEntity toEntity(UserDTO dto) {
		UserEntity entity = null;
		if (dto != null) {
			entity = mapper.map(dto, UserEntity.class);
		}
		return entity;
	}

	public List<UserDTO> toListDTO(List<UserEntity> entities) {
		List<UserDTO> list = Arrays.asList(mapper.map(entities, UserDTO[].class));
		return list;
	}

	public List<UserEntity> toListEntity(List<UserDTO> dtos) {
		List<UserEntity> list = Arrays.asList(mapper.map(dtos, UserEntity[].class));
		return list;
	}

	public List<UserDTO> toDTO(List<Object[]> params) {
		List<UserDTO> result = new ArrayList<>();
		params.forEach(item -> {
			UserDTO dto = new UserDTO();
			dto.setUsername(String.valueOf(item[0]));
			dto.setEmail(String.valueOf(item[1]));
			result.add(dto);
		});
		return result;
	}
}
