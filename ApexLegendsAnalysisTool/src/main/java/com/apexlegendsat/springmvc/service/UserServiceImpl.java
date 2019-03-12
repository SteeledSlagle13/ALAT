package com.apexlegendsat.springmvc.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apexlegendsat.springmvc.DAO.UserDAO;
import com.apexlegendsat.springmvc.entity.UserEntity;
import com.apexlegendsat.springmvc.view.UserView;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	static Logger logger = LogManager.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	private UserDAO userDao;

	@Override
	public void deleteUserById(long id) {
		userDao.deleteUserEntityById(id);
	}

	@Override
	public boolean doesUserExist(UserEntity user) {
		return findByName(user.getUsername()) != null;
	}

	@Override
	public List<UserEntity> findAllUsers() {
		logger.info("in UserServiceImpl - findAllUsers()");
		return userDao.findAllUserEntities();
	}

	@Override
	public UserEntity findById(long id) {
		return userDao.findUserEntityById(id);
	}

	@Override
	public UserEntity findByName(String name) {
		return userDao.findUserEntityByName(name);
	}
	
	@Override
	public void purgeUsers() {
		userDao.purgeUserEntities();
	}

	@Override
	public void saveUser(UserEntity user) {
		userDao.saveUserEntity(user);
	}

	@Override
	public void updateUser(UserEntity user) {
		userDao.updateUserEntity(user);
	}
	
	@Override
	public UserView convertUserEntityToUserView(UserEntity userEnt) {
		UserView userView = new UserView();
		
		userView.setAddress(userEnt.getAddress());
		userView.setEmail(userEnt.getEmail());
		userView.setUsername(userEnt.getUsername());
		
		return userView;
	}

}
