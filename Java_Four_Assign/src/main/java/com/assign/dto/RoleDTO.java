package com.assign.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class RoleDTO extends BaseDTO<RoleDTO> {
	private String name;
	private String code;
	private List<UserDTO> users = new ArrayList<>();
}
