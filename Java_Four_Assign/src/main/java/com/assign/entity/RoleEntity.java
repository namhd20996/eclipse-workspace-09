package com.assign.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {

	@Column(name = "name")
	private String name;
	@Column(name = "code")
	private String code;
	@ManyToMany(mappedBy = "roleEntities")
	@ToString.Exclude
	private List<UserEntity> users = new ArrayList<>();

}
