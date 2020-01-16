package com.handong.webcamp.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.handong.webcamp.dto.UserDto;
import com.handong.webcamp.util.ServiceResult;

@Transactional
public interface UserService {
	ServiceResult add(UserDto user);
	@Transactional(readOnly=true)
	UserDto get(String id);
	@Transactional(readOnly=true)
	List<UserDto> getAll();
	void deleteAll();
	void delete(String id);
	void update(UserDto user);
}
