package com.assign.entity;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.assign.constant.SystemConstant;

import lombok.Data;
import lombok.ToString;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = SystemConstant.STORE_FIND_USER_BY_HREF, 
								procedureName = "sp_selectUsersLikedVideoByVideoHref", 
								parameters = @StoredProcedureParameter(name = SystemConstant.PARA_VIDEO_HREF, type = String.class)) })
@Data
@Entity
@Table(name = "`user`")
public class UserEntity extends BaseEntity {
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "isactive")
	private Boolean isActive;
	@Column(name = "verify")
	private String verify;
	@Column(name = "timeactive")
	private Timestamp timeActive;
	@OneToMany(mappedBy = "user")
	@ToString.Exclude
	private List<HistoryEntity> historyEntities = new ArrayList<>();
	@ManyToMany(fetch = FetchType.LAZY)
	@ToString.Exclude
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = {
			@JoinColumn(name = "roleid") })
	private List<RoleEntity> roleEntities = new ArrayList<>();

}
