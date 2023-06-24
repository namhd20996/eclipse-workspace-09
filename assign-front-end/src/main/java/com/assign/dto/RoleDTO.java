package com.assign.dto;

import java.util.ArrayList;
import java.util.List;

import com.assign.entity.UserEntity;

import lombok.Data;
import lombok.ToString;

@Data
public class RoleDTO extends BaseDTO<RoleDTO> {
	private String code;
	private String name;
	@ToString.Exclude
	private List<UserEntity> users = new ArrayList<>();

}
