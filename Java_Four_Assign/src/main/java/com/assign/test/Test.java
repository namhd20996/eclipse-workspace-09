package com.assign.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.assign.dto.HistoryDTO;
import com.assign.dto.UserDTO;
import com.assign.entity.HistoryEntity;
import com.assign.entity.UserEntity;

public class Test {
	public static void main(String[] args) {
		ModelMapper mapper = new ModelMapper();
		
		// Chuyển đổi đơn nếu trong class đơn có List nó cũng có thể map được
		// Khi map với nhau thì 2 class cần cùng tên filed
		UserEntity e1 = new UserEntity();
		e1.setId(1l);
		e1.setUsername("duuuuu");
		
		UserEntity e2 = new UserEntity();
		e2.setId(12l);
		e2.setUsername("duuuuummmmmmmmmmmm");
		
		HistoryEntity h1 = new HistoryEntity();
		h1.setIsLike(true);
		
		HistoryEntity h2 = new HistoryEntity();
		h2.setIsLike(true);
		
		List<HistoryEntity> listH = new ArrayList<>();
		listH.add(h2);
		listH.add(h1);
		
		e1.setHistoryEntities(listH);
		
		UserDTO u = mapper.map(e1, UserDTO.class);
		System.out.println(u);
		
		// Chuyển đổi List
		List<UserEntity> list = new ArrayList<>();
		list.add(e2);
		list.add(e1);
		
		List<UserDTO> listDTO = Arrays.asList(mapper.map(list, UserDTO[].class));
		for (HistoryDTO his : listDTO.get(1).getHistoryEntities()) {
			System.out.println(his);
		}
		
	
	}
}
