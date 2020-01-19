package com.handong.webcamp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.handong.webcamp.dto.UserDto;

@Mapper
public interface UserMapper {
	public void insert(UserDto user);
	public UserDto selectOne(String id);
	public List<UserDto> selectList();
	public int userCount();
	public void delete(String id);
	public void deleteAll();
	public void update(UserDto user);
}
