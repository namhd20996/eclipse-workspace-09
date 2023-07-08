package com.assign.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO extends BaseDTO<RoleDTO> {
	private String name;
	private String code;
	private List<UserDTO> users = new ArrayList<>();
}
