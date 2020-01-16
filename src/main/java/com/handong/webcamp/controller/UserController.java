package com.handong.webcamp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.handong.webcamp.dto.UserDto;
import com.handong.webcamp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		logger.info("user list request");
		List<UserDto> list = userService.getAll(); 
		
		mv.addObject("users", list);
		mv.setViewName("userList");
		
		return mv;
	}
	
}