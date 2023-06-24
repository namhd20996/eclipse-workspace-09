package com.assign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assign.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUsernameAndStatus(String username, int status);

	Boolean existsByUsername(String username);

	UserEntity findOneByEmail(String email);

	UserEntity findOneByUsernameAndEmail(String username, String email);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE UserEntity u SET u.password =:password WHERE u.username =:username AND u.verify =:verify")
	int updatePassword(@Param("password") String password, @Param("username") String username, @Param("verify") String verify);
}
