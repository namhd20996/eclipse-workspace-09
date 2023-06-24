package com.assign.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.ToString;
@Data
@Entity(name = "role")
public class RoleEntity extends BaseEntity {
	@Column
	private String code;
	@Column
	private String name;
	@ManyToMany(mappedBy = "roles")
	@ToString.Exclude
	private List<UserEntity> users = new ArrayList<>();

}
