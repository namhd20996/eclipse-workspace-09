package com.assign.service;

import java.util.List;

import com.assign.dto.UserDTO;

public interface IUserService {
	UserDTO findOneById(Long id);

	UserDTO findOnedByEmail(String email);

	UserDTO findOneByUsername(String username);

	UserDTO findOneByUsernameAndPassword(UserDTO userDTO);
	
	UserDTO findOneByUsernameAndEmail(UserDTO userDTO);
	
	Boolean updateUserByUsernameAndVerify(UserDTO userDTO);
	
	List<UserDTO> findUsersLikedVideoByVideoHref(String href);
	
	List<UserDTO> findAll();
	
	List<UserDTO> findAll(int pageNumber, int pageSize);

	UserDTO create(UserDTO userDTO);

	UserDTO update(UserDTO userDTO);
	
	UserDTO delete(UserDTO userDTO);
}
