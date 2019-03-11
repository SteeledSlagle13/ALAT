package com.apexlegendsat.springmvc.service;

import java.util.List;

import com.apexlegendsat.springmvc.entity.UserEntity;

public interface UserService {
	
	void purgeUsers();
	
	void deleteUserById(long id);
	
	public boolean doesUserExist(UserEntity user);

	List<UserEntity> findAllUsers();
	
	UserEntity findById(long id);

	UserEntity findByName(String name);
	
	void saveUser(UserEntity user);

	void updateUser(UserEntity user);

}
