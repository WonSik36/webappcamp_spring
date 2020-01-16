package com.handong.webcamp.dto;

import lombok.Data;

@Data
public class UserDto {
	private String userID;
	private String userPassword;
	private String userName;
	private String userGender;
	private String userEmail;
}
