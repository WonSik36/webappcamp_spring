package com.handong.webcamp.service;

import java.util.List;

import com.handong.webcamp.dao.UserDao;
import com.handong.webcamp.dto.UserDto;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void add(UserDto user) {
		userDao.add(user);
	}

	@Override
	public UserDto get(String id) {
		return userDao.get(id);
	}

	@Override
	public List<UserDto> getAll() {
		return userDao.getAll();
	}

	@Override
	public void deleteAll() {
		userDao.deleteAll();
	}

	@Override
	public void delete(String id) {
		userDao.delete(id);
	}

	@Override
	public void update(UserDto user) {
		userDao.update(user);
	}

}
