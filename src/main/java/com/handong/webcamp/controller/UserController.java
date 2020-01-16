package com.handong.webcamp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.handong.webcamp.dto.UserDto;
import com.handong.webcamp.service.UserService;

@Controller
public class UserController {
	@Autowired UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("user list request");
		List<UserDto> list = userService.getAll(); 
		
		model.addAttribute("users", list);
		
		return "userList";
	}
	
}