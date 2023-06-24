package com.assign.service;

import org.springframework.data.repository.query.Param;

import com.assign.dto.UserDTO;

public interface IUserService {
	Boolean existsByUsername(String username);
	
	UserDTO findOneById(Long id);
	
	UserDTO saveOrUpdate(UserDTO dto);

	UserDTO findOneByUsernameAndEmail(String username, String email);
	
	int updatePassword(@Param("password") String password, @Param("username") String username, @Param("verify") String verify);

}
