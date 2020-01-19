package com.handong.webcamp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.handong.webcamp.dao.UserDao;
import com.handong.webcamp.dto.UserDto;
import com.handong.webcamp.util.UpdateResult;

@Service("userServiceImplJdbc")
public class UserServiceImplJdbc implements UserService {
	@Autowired private UserDao userDao;
	
	@Override
	public UpdateResult add(UserDto user) {
		return userDao.add(user);
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
	public UpdateResult deleteAll() {
		return userDao.deleteAll();
	}

	@Override
	public UpdateResult delete(String id) {
		return userDao.delete(id);
	}

	@Override
	public UpdateResult update(UserDto user) {
		return userDao.update(user);
	}

}
