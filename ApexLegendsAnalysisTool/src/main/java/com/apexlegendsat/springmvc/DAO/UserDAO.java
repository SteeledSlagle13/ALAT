package com.apexlegendsat.springmvc.DAO;

import java.util.List;

import com.apexlegendsat.springmvc.entity.UserEntity;

public interface UserDAO {
	
	void deleteUserEntityById(long userId);
	
	List<UserEntity> findAllUserEntities();
	
	UserEntity findUserEntityById(long userId);
	
	UserEntity findUserEntityByName(String userName);
	
	void purgeUserEntities();
	
	void saveUserEntity(UserEntity userEntity);
	
	void updateUserEntity(UserEntity userEntity);
}
