package com.assign.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`video`")
public class VideoEntity extends BaseEntity {
	@Column(name = "title", length = 255)
	private String title;
	@Column(name = "href", length = 255)
	private String href;
	@Column(name = "poster", length = 255)
	private String poster;
	@Column(name = "views")
	private Integer views;
	@Column(name = "shares")
	private Integer shares;
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	@Column(name = "isActive")
	private Boolean isActive;
	@OneToMany(mappedBy = "video")
	@ToString.Exclude
	private List<HistoryEntity> historyEntities = new ArrayList<>();

}