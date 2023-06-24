package com.assign.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.assign.constant.SystemConstant;
import com.assign.dto.MyUser;
import com.assign.entity.UserEntity;
import com.assign.repository.IUserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUsernameAndStatus(username, SystemConstant.USER_ACTIVE);
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		userEntity.getRoles().forEach(item -> authorities.add(new SimpleGrantedAuthority(item.getCode())));
		MyUser myUser = new MyUser(userEntity.getUsername(), userEntity.getPassword(), true, true, true, true,
				authorities);
		myUser.setFullname(userEntity.getFullname());
		myUser.setId(userEntity.getId());
		return myUser;
	}

}
