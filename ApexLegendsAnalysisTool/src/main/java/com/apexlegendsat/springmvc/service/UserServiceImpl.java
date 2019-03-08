package com.apexlegendsat.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.apexlegendsat.springmvc.entity.UserEntity;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final AtomicLong counter = new AtomicLong();

	private static List<UserEntity> users;

	static {
		users = populateDummyUsers();
	}

	public List<UserEntity> findAllUsers() {
		return users;
	}

	public UserEntity findById(long id) {
		for (UserEntity user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public UserEntity findByName(String name) {
		for (UserEntity user : users) {
			if (user.getUsername().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}

	public void saveUser(UserEntity user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(UserEntity user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {

		for (Iterator<UserEntity> iterator = users.iterator(); iterator.hasNext();) {
			UserEntity user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
			}
		}
	}

	public boolean isUserExist(UserEntity user) {
		return findByName(user.getUsername()) != null;
	}

	public void deleteAllUsers() {
		users.clear();
	}

	private static List<UserEntity> populateDummyUsers() {
		List<UserEntity> users = new ArrayList<UserEntity>();
		users.add(new UserEntity(counter.incrementAndGet(), "billC", "OVAL OFFICE", "ovalOdude90s@westwing.com",
				"99problemsBeingPrezAint1"));
		users.add(new UserEntity(counter.incrementAndGet(), "clarkyBoi", "UTSA", "larry@notusaa.aln", "wr1teInC"));
		users.add(new UserEntity(counter.incrementAndGet(), "hugh", "SEATURTLE COVE", "iInventedHashing@supersecureemail.com",
				"uncrackablepassword"));
		users.add(new UserEntity(counter.incrementAndGet(), "SS0113", "PLACE", "SteeledSlagle13@gmail.com",
				"password"));
		return users;
	}

}
