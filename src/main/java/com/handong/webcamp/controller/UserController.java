package com.handong.webcamp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.handong.webcamp.dto.UserDto;
import com.handong.webcamp.service.UserService;
import com.handong.webcamp.util.ServiceResult;

@Controller
@RequestMapping("/users")
@SessionAttributes("userID")
public class UserController {
	@Autowired UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView userList(ModelAndView mv) {
		logger.info("user list request");
		List<UserDto> list = userService.getAll(); 
		
		mv.addObject("users", list);
		mv.setViewName("userList");
		
		return mv;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView user(@PathVariable String id, ModelAndView mv) {
		logger.info("user "+id+" request");
		UserDto user = userService.get(id); 
		List<UserDto> list = new ArrayList<UserDto>();
		list.add(user);
		
		mv.addObject("users", list);
		mv.setViewName("userList");
		
		return mv;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView userForm(ModelAndView mv) {
		logger.info("user add form request");

		mv.setViewName("userForm");
		
		return mv;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView userAdd(@ModelAttribute UserDto user, ModelAndView mv) {
		
		logger.info("user add request");
		
		if(!user.isValid()) {
			mv.addObject("message", ServiceResult.ERR_REQUIRED.status());
			mv.setViewName("result");
			return mv;
		}
		
		ServiceResult res = userService.add(user);
		
		if(res.isOK())
			mv.addObject("userID",user.getUserID());
		
		mv.addObject("message", res.status());
		mv.setViewName("result");
		
		return mv;
	}
}