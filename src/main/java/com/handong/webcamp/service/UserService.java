package com.handong.webcamp.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.handong.webcamp.dto.UserDto;
import com.handong.webcamp.util.UpdateResult;

@Transactional
public interface UserService {
	UpdateResult add(UserDto user);
	@Transactional(readOnly=true)
	UserDto get(String id);
	@Transactional(readOnly=true)
	List<UserDto> getAll();
	UpdateResult deleteAll();
	UpdateResult delete(String id);
	UpdateResult update(UserDto user);
}
