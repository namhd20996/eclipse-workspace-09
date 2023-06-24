package com.assign.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assign.entity.RoleEntity;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long>{
	List<RoleEntity> findByName(String name);
}
