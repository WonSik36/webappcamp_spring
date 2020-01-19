package com.handong.webcamp.mybatis;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.handong.webcamp.dto.UserDto;
import com.handong.webcamp.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:database.properties")
@ContextConfiguration(locations = { "application-context.xml" })
public class UserMapperTest {
	@Autowired UserMapper userMapper;
	List<UserDto> list;
	
	@Before
	public void setUp() {
		userMapper.deleteAll();
		
		UserDto u1 = new UserDto();
		u1.setUserID("id1");
		u1.setUserPassword("pw1");
		u1.setUserEmail("email1@example.com");
		u1.setUserName("name1");
		u1.setUserGender("m");
		
		UserDto u2 = new UserDto();
		u2.setUserID("id2");
		u2.setUserPassword("pw2");
		u2.setUserEmail("email2@example.com");
		u2.setUserName("name2");
		u2.setUserGender("f");
		
		UserDto u3 = new UserDto();
		u3.setUserID("id3");
		u3.setUserPassword("pw3");
		u3.setUserEmail("email3@example.com");
		u3.setUserName("name3");
		u3.setUserGender("m");
		
		UserDto u4 = new UserDto();
		u4.setUserID("id4");
		u4.setUserPassword("pw4");
		u4.setUserEmail("email4@example.com");
		u4.setUserName("name4");
		u4.setUserGender("f");
		
		UserDto u5 = new UserDto();
		u5.setUserID("id5");
		u5.setUserPassword("pw5");
		u5.setUserEmail("email5@example.com");
		u5.setUserName("name5");
		u5.setUserGender("m");
		
		list = new ArrayList<UserDto>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);
		list.add(u5);
	}
	
	@Test
	public void joinTest() {
		for(UserDto u:list) {
			userMapper.insert(u);
		}
		
		List<UserDto> dbList = userMapper.selectList();
		compareUserList(list, dbList);
	}
	
	@Test
	public void updateTest() {
		for(UserDto u:list) {
			userMapper.insert(u);
		}
		
		UserDto u = list.get(0);
		u.setUserName("updatedName");
		u.setUserEmail("updatedEmail");
		u.setUserPassword("updatedPassword");
		
		userMapper.update(u);
		
		UserDto updatedUser = userMapper.selectOne(u.getUserID());
		
		compareUser(u,updatedUser);
	}
	
	@Test
	public void deleteTest() {
		for(UserDto u:list) {
			userMapper.insert(u);
		}
		
		UserDto u = list.get(0);
		list.remove(0);
		userMapper.delete(u.getUserID());
		
		List<UserDto> dbList = userMapper.selectList();
		
		compareUserList(list, dbList);
	}
	
	private void compareUserList(List<UserDto> list1, List<UserDto> list2) {
		assertThat(list1.size(),is(list2.size()));
		
		for(int i=0;i<list1.size();i++) {
			compareUser(list1.get(i),list2.get(i));
		}
	}
	
	private void compareUser(UserDto u1, UserDto u2) {
		assertThat(u1.getUserID(), is(u2.getUserID()));
		assertThat(u1.getUserPassword(), is(u2.getUserPassword()));
		assertThat(u1.getUserName(), is(u2.getUserName()));
		assertThat(u1.getUserEmail(), is(u2.getUserEmail()));
		assertThat(u1.getUserGender(), is(u2.getUserGender()));
	}
}
