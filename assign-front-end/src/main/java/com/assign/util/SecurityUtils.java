package com.assign.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.assign.dto.MyUser;

public class SecurityUtils {

	public static MyUser getPrincipal() {
		MyUser myUser = (MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
		return myUser;
	}

	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() {
		List<String> results = new ArrayList<>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) (SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		authorities.forEach(item -> results.add(item.getAuthority()));
		return results;
	}
}
