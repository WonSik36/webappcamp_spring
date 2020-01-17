package com.handong.webcamp.dao;

import java.util.List;
import com.handong.webcamp.dto.UserDto;
import com.handong.webcamp.util.UpdateResult;;

public interface UserDao {
	public UpdateResult add(UserDto user);
	public UserDto get(String id);
	public List<UserDto> getAll();
	public UpdateResult delete(String id);
	public UpdateResult deleteAll();
	public int getCount();
	public UpdateResult update(UserDto user);
}
