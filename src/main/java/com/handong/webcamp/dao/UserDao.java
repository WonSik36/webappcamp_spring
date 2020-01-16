package com.handong.webcamp.dao;

import java.util.List;
import com.handong.webcamp.dto.UserDto;;

public interface UserDao {
	public void add(UserDto user);
	public UserDto get(String id);
	public List<UserDto> getAll();
	public void delete(String id);
	public void deleteAll();
	public int getCount();
	public void update(UserDto user);
}
