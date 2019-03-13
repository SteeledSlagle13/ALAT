package com.apexlegendsat.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apexlegendsat.springmvc.DAO.UserDAO;
import com.apexlegendsat.springmvc.entity.UserEntity;
import com.apexlegendsat.springmvc.view.UserView;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	static Logger logger = LogManager.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	private UserDAO userDao;

	@Override
	public void deleteUserById(int id) {
		userDao.deleteUserEntityById(id);
	}

	@Override
	public boolean doesUserExist(UserView user) {
		return findByName(user.getUsername()) != null;
	}

	@Override
	public List<UserView> findAllUsers() {
		List<UserEntity> userEntities = userDao.findAllUserEntities();
		
		List<UserView> userViews = new ArrayList<UserView>();
		for(UserEntity userEntity : userEntities) {
			userViews.add(convertUserEntityToUserView(userEntity));
		}
		
		return userViews;
	}

	@Override
	public UserView findById(int id) {
		return convertUserEntityToUserView(userDao.findUserEntityById(id));
	}

	@Override
	public UserView findByName(String name) {
		return convertUserEntityToUserView(userDao.findUserEntityByName(name));
	}

	@Override
	public void saveUser(UserView user) {
		userDao.saveUserEntity(convertUserViewToUserEntity(user));
	}

	@Override
	public void updateUser(UserView user) {
		userDao.updateUserEntity(convertUserViewToUserEntity(user));
	}
	
	@Override
	public UserView convertUserEntityToUserView(UserEntity userEnt) {
		if(userEnt == null) {
			return null;
		}
		UserView userView = new UserView();
		
		userView.setAddress(userEnt.getAddress());
		userView.setEmail(userEnt.getEmail());
		userView.setUsername(userEnt.getUsername());
		userView.setPassword(userEnt.getPassword());
		
		return userView;
	}
	
	@Override
	public UserEntity convertUserViewToUserEntity(UserView userView) {
		if(userView == null) {
			return null;
		}
		UserEntity userEntity = new UserEntity();

		userEntity.setAddress(userView.getAddress());
		userEntity.setEmail(userView.getEmail());
		userEntity.setUsername(userView.getUsername());
		userEntity.setPassword(userView.getPassword());
		
		return userEntity;
	}

}
