package com.apexlegendsat.springmvc.DAO;

import java.util.List;

import com.apexlegendsat.springmvc.entity.UserEntity;

public interface UserDAO {
	
	void deleteUserEntityById(int userId);
	
	List<UserEntity> findAllUserEntities();
	
	UserEntity findUserEntityById(int userId);
	
	UserEntity findUserEntityByName(String userName);
	
	void saveUserEntity(UserEntity userEntity);
	
	void updateUserEntity(UserEntity userEntity);
}
