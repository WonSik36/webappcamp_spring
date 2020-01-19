package com.handong.webcamp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handong.webcamp.dto.UserDto;
import com.handong.webcamp.mapper.UserMapper;
import com.handong.webcamp.util.UpdateResult;

@Service("userServiceImplMapper")
public class UserServiceImplMapper implements UserService{
	@Autowired UserMapper userMapper;
	
	@Override
	public UpdateResult add(UserDto user) {
		userMapper.insert(user);
		return UpdateResult.OK;
	}

	@Override
	public UserDto get(String id) {
		return userMapper.selectOne(id);
	}

	@Override
	public List<UserDto> getAll() {
		return userMapper.selectList();
	}

	@Override
	public UpdateResult deleteAll() {
		userMapper.deleteAll();
		return UpdateResult.OK;
	}

	@Override
	public UpdateResult delete(String id) {
		userMapper.delete(id);
		return UpdateResult.OK;
	}

	@Override
	public UpdateResult update(UserDto user) {
		userMapper.update(user);
		return UpdateResult.OK;
	}
}
