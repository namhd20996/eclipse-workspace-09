package com.assign.service.impl;

import java.sql.Timestamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assign.converter.UserConverter;
import com.assign.dto.UserDTO;
import com.assign.entity.RoleEntity;
import com.assign.entity.UserEntity;
import com.assign.repository.IRoleRepository;
import com.assign.repository.IUserRepository;
import com.assign.service.IUserService;
import com.assign.util.Email;
import com.assign.util.RandomVerify;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	private UserConverter converter;

	@Override
	public Boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public UserDTO findOneById(Long id) {
		return converter.toDTO(userRepository.findOne(id));
	}

	@Override
	@Transactional
	public UserDTO saveOrUpdate(UserDTO dto) {
		UserEntity entity = null;
		if (dto.getId() != null) {
			entity = userRepository.findOne(dto.getId());
			if (dto.getFullname() != null && dto.getBirthDay() != null && dto.getGender() != null) {
				entity.setFullname(dto.getFullname());
				entity.setBirthDay(dto.getBirthDay());
				entity.setGender(dto.getGender());
			}
			if (dto.getPasswordOld() != null) {
				boolean check = encoder.matches(dto.getPasswordOld(), entity.getPassword());
				if (!check) {
					return null;
				}
			}
			if (dto.getPassword() != null) {
				entity.setPassword(encoder.encode(dto.getPassword()));
			}
		} else {
			if (!existsByUsername(dto.getUsername())) {
				List<RoleEntity> roles = roleRepository.findByName("USER");
				entity = converter.toEntity(dto);
				entity.setStatus(1);
				entity.setRoles(roles);
				entity.setPassword(encoder.encode(dto.getPassword()));
			}
		}
		return converter.toDTO(userRepository.save(entity));
	}

	@Override
	@Transactional
	public UserDTO findOneByUsernameAndEmail(String username, String email) {
		UserEntity user = null;
		user = userRepository.findOneByUsernameAndEmail(username, email);
		if (user != null) {
			user.setVerify(RandomVerify.soNgauNhien());
			user.setTimeActive(new Timestamp(System.currentTimeMillis()));
			Email.sendEmail(user.getEmail(), "Gửi từ Quiz Online", Email.getNoiDung(user));
			return saveOrUpdate(converter.toDTO(user));
		}
		return null;
	}

	@Override
	@Transactional
	public int updatePassword(String password, String username, String verify) {
		return userRepository.updatePassword(encoder.encode(password), username, verify);
	}

}
