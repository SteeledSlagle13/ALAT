package com.apexlegendsat.springmvc.service;

import java.util.List;

import com.apexlegendsat.springmvc.entity.UserEntity;

public interface UserService {

	UserEntity findById(long id);

	UserEntity findByName(String name);

	void saveUser(UserEntity user);

	void updateUser(UserEntity user);

	void deleteUserById(long id);

	List<UserEntity> findAllUsers();

	void deleteAllUsers();

	public boolean isUserExist(UserEntity user);

}
