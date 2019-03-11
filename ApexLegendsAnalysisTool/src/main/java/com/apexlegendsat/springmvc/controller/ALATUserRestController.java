package com.apexlegendsat.springmvc.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.apexlegendsat.springmvc.entity.UserEntity;
import com.apexlegendsat.springmvc.service.UserService;
import com.apexlegendsat.springmvc.view.UserView;

@RestController
public class ALATUserRestController {

	static Logger logger = LogManager.getLogger(ALATUserRestController.class.getName());

	@Autowired
	private UserService userService;
	
	private UserView viewableUser = new UserView();

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<UserEntity>> listAllUsers() {
		logger.info(userService);
		List<UserEntity> users = userService.findAllUsers();
		logger.info("should have users.");
		if (users.isEmpty()) {
			return new ResponseEntity<List<UserEntity>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<UserEntity>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> getUser(@PathVariable("id") long id) {

		logger.info("Fetching user with id : " + id);
		UserEntity user = userService.findById(id);

		if (user == null) {
			logger.error("user with id : " + id + " not found");
			return new ResponseEntity<UserEntity>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody UserEntity user, UriComponentsBuilder ucBuilder) {
		logger.info("creating user " + user.getUsername());

		if (userService.doesUserExist(user)) {
			logger.error("A User with name " + user.getUsername() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserEntity> updateUser(@PathVariable("id") long id, @RequestBody UserEntity user) {
		logger.info("updating user " + id);

		UserEntity currentUser = userService.findById(id);

		if (currentUser == null) {
			logger.info("user with id " + id + " not found");
			return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
		}

		currentUser.setUsername(user.getUsername());
		currentUser.setAddress(user.getAddress());
		currentUser.setEmail(user.getEmail());

		userService.updateUser(currentUser);
		return new ResponseEntity<UserEntity>(currentUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserEntity> deleteUser(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting User with id " + id);

		UserEntity user = userService.findById(id);
		if (user == null) {
			logger.error("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
		}

		userService.deleteUserById(id);
		return new ResponseEntity<UserEntity>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public ResponseEntity<UserEntity> deleteAllUsers() {
		
		logger.info("Deleting All Users");

		userService.purgeUsers();
		return new ResponseEntity<UserEntity>(HttpStatus.NO_CONTENT);
	}
}