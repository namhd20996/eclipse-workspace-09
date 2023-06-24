package com.laptrinhjavaweb.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;

@RestController(value = "newAPIOfWeb")
public class NewAPI {
	
	@Autowired
	private UserRepository repository;
	
	@PutMapping("/api/test")
	public UserEntity updateUserEntity(@RequestBody UserEntity entity) {
		return repository.findOne(entity.getId());
	}
	
}
