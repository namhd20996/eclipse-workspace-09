package com.assign.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
@Data
@MappedSuperclass
public abstract class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "createddate")
	private Date createdDate;
	@Column(name = "lastmodifieddate")
	private Date lastModifiedDate;
	@Column(name = "createdby")
	private String createdBy;
	@Column(name = "lastmodifiedby")
	private String lastModifiedBy;
	
}
