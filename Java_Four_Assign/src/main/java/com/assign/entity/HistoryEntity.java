package com.assign.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "history")
public class HistoryEntity extends BaseEntity {

	@JoinColumn(name = "userid")
	@ManyToOne
	@ToString.Exclude
	private UserEntity user;
	@JoinColumn(name = "videoid")
	@ManyToOne
	@ToString.Exclude
	private VideoEntity video;
	@Column(name = "viewdate")
	private Timestamp viewDate;
	@Column(name = "islike")
	private Boolean isLike;
	@Column(name = "likedate")
	private Timestamp likeDate;
}
