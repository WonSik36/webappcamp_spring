package com.handong.webcamp.dto;

import lombok.Data;

@Data
public class UserDto {
	private String userID;
	private String userPassword;
	private String userName;
	private String userGender;
	private String userEmail;
	
	public boolean isValid() {
		if(userID.length()>0 && userPassword.length()>0 && userName.length()>0 
				&& userGender.length()>0 && userEmail.length()>0)
			return true;
		else
			return false;
	}
}
