package com.handong.webcamp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handong.webcamp.dao.UserDao;
import com.handong.webcamp.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	@Autowired private UserDao userDao;
	
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
