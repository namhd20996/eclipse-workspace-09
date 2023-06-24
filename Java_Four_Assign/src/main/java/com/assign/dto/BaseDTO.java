package com.assign.dto;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BaseDTO<T> {
	private Long id;
	private Date createdDate;
	private Date lastModifiedDate;
	private String createdBy;
	private String lastModifiedBy;
	private long[] ids;
	private List<T> listResult = new ArrayList<>();
	private Integer page;
	private Integer limit;
	private Integer totalPage;
	private Integer totalItem;
	private String sortName;
	private String sortBy;
	private String alert;
	private String message;
	private String type;
}
