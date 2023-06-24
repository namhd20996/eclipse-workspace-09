package com.assign.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.assign.constant.SystemConstant;
import com.assign.converter.UserConverter;
import com.assign.dao.IUserDao;
import com.assign.dto.UserDTO;
import com.assign.entity.UserEntity;
import com.assign.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Inject
	private IUserDao userDao;

	@Override
	public UserDTO findOneById(Long id) {
		return UserConverter.getInstance().toDTO(userDao.findOneById(id));
	}

	@Override
	public UserDTO findOnedByEmail(String email) {
		return UserConverter.getInstance().toDTO(userDao.findOnedByEmail(email));
	}

	@Override
	public UserDTO findOneByUsername(String username) {
		return UserConverter.getInstance().toDTO(userDao.findOneByUsername(username));
	}

	@Override
	public UserDTO findOneByUsernameAndPassword(UserDTO userDTO) {
		return UserConverter.getInstance()
				.toDTO(userDao.findOneByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword()));
	}

	@Override
	public List<UserDTO> findAll() {
		return UserConverter.getInstance().toListDTO(userDao.findAll());
	}

	@Override
	public List<UserDTO> findAll(int pageNumber, int pageSize) {
		return UserConverter.getInstance().toListDTO(userDao.findAll(pageNumber, pageSize));
	}

	@Override
	public UserDTO create(UserDTO userDTO) {
		UserEntity entity = UserConverter.getInstance().toEntity(userDTO);
		return UserConverter.getInstance().toDTO(userDao.create(entity));
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		UserEntity entity = UserConverter.getInstance().toEntity(userDTO);
		return UserConverter.getInstance().toDTO(userDao.update(entity));
	}

	@Override
	public UserDTO delete(UserDTO userDTO) {
		userDTO.setIsActive(Boolean.FALSE);
		UserEntity entity = UserConverter.getInstance().toEntity(userDTO);
		return UserConverter.getInstance().toDTO(userDao.update(entity));
	}

	@Override
	public UserDTO findOneByUsernameAndEmail(UserDTO userDTO) {
		return UserConverter.getInstance()
				.toDTO(userDao.findOneByUsernameAndEmail(userDTO.getUsername(), userDTO.getEmail()));
	}

	@Override
	public Boolean updateUserByUsernameAndVerify(UserDTO userDTO) {
		return userDao.updateUserByUsernameAndVerify(userDTO.getPassword(), userDTO.getUsername(), userDTO.getVerify());
	}

	@Override
	public List<UserDTO> findUsersLikedVideoByVideoHref(String href) {
		Map<String, Object> map = new HashMap<>();
		map.put(SystemConstant.PARA_VIDEO_HREF, href);
		return UserConverter.getInstance().toDTO(userDao.findUsersLikedVideoByVideoHref(map));
	}

}
