package com.assign.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.assign.entity.RoleEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO<UserDTO> {
	private String username;
	private String password;
	private String email;
	private Boolean isAdmin;
	private Boolean isActive;
	private String gender;
	private String fullName;
	private String verify;
	private Timestamp timeActive;
	private List<HistoryDTO> historyEntities;
	private List<RoleEntity> roleEntities = new ArrayList<>();
}
