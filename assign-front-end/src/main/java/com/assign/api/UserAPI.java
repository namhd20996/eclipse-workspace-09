package com.assign.api;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assign.dto.UserDTO;
import com.assign.service.IUserService;

@RestController(value = "newAPIOfUser")
public class UserAPI {

	@Autowired
	private IUserService userService;

	@PostMapping("/api/user")
	public UserDTO register(@RequestBody UserDTO dto, HttpServletResponse resp) {
		UserDTO user = userService.saveOrUpdate(dto);
		if (user != null) {
			resp.setStatus(200);
		} else {
			resp.setStatus(400);
		}
		return dto;
	}

	@PutMapping("/api/user")
	public UserDTO update(@RequestBody UserDTO dto, HttpServletResponse resp) {
		UserDTO user = userService.saveOrUpdate(dto);
		if (user != null) {
			resp.setStatus(200);
		} else {
			resp.setStatus(400);
		}
		return user;
	}
}
