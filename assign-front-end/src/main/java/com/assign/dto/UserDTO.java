package com.assign.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.assign.entity.RoleEntity;
import lombok.Data;
import lombok.ToString;

@Data
public class UserDTO extends BaseDTO<UserDTO> {
	private String username;
	private String email;
	private String passwordOld;
	private String password;
	private String verify;
	private String fullname;
	private String gender;
	private Date birthDay;
	private Double schoolfee;
	private Timestamp timeActive;
	private Double mark;
	@ToString.Exclude
	private List<RoleEntity> roles = new ArrayList<>();

}
