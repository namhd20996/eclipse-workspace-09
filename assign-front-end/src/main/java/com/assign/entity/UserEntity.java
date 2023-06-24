package com.assign.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private Integer status;
	@Column
	private String verify;
	@Column
	private String fullname;
	@Column
	private String gender;
	@Column(name = "birthday")
	private Date birthDay;
	@Column
	private Double schoolfee;
	@Column(name = "timeactive")
	private Timestamp timeActive;
	@Column
	private Double mark;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = {
			@JoinColumn(name = "roleid") })
	@ToString.Exclude
	private List<RoleEntity> roles = new ArrayList<>();

}
