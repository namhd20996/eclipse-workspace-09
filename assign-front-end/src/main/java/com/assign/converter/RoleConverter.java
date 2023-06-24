package com.assign.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assign.dto.RoleDTO;
import com.assign.entity.RoleEntity;

@Component
public class RoleConverter {
	@Autowired
	private ModelMapper mapper;

	public RoleEntity toEntity(RoleDTO dto) {
		RoleEntity entity = mapper.map(dto, RoleEntity.class);
		return entity;
	}

	public RoleDTO toDTO(RoleEntity entity) {
		RoleDTO dto = mapper.map(entity, RoleDTO.class);
		return dto;
	}
	
	
}
