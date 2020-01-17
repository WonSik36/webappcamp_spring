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
import com.handong.webcamp.util.UpdateResult;

@Controller
@RequestMapping("/users")
@SessionAttributes("userID")
public class UserController {
	@Autowired UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * User List
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView userList(ModelAndView mv) {
		logger.info("user list request");
		List<UserDto> list = userService.getAll(); 
		
		mv.addObject("users", list);
		mv.setViewName("userList");
		
		return mv;
	}
	
	/**
	 * Get Specific User's Form to Update
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView userForm(@PathVariable String id, ModelAndView mv) {
		logger.info("user "+id+" update form request");
		UserDto user = userService.get(id); 
		
		mv.addObject("user", user);
		mv.setViewName("userEdit");
		
		return mv;
	}
	
	/**
	 * Update User
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ModelAndView userUpdate(@ModelAttribute UserDto user, ModelAndView mv) {
		logger.info("user "+user.getUserID()+" update request");
		UpdateResult res = userService.update(user);
		
		mv.addObject("message", res.status());
		mv.setViewName("redirect:/users/result");
		
		return mv;
	}
	
	/**
	 * Delete User
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ModelAndView userDelete(@PathVariable String id, ModelAndView mv) {
		logger.info("user "+id+" delete request");
		UpdateResult res = userService.delete(id);
		
		mv.addObject("message", res.status());
		mv.setViewName("redirect:/users/result");
		
		return mv;
	}
	
	/**
	 * Get User Registration Form
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView userForm(ModelAndView mv) {
		logger.info("user add form request");

		mv.setViewName("userForm");
		
		return mv;
	}
	
	/**
	 * Add User
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView userAdd(@ModelAttribute UserDto user, ModelAndView mv) {
		
		logger.info("user add request");
		
		// invalid form was passed
		if(!user.isValid()) {
			mv.addObject("message", UpdateResult.ERR_REQUIRED.status());
			mv.setViewName("result");
		}else {			
			UpdateResult res = userService.add(user);
			
			mv.addObject("message", res.status());
			mv.setViewName("result");
		}
		
		return mv;
	}
	
	/**
	 * Result
	 */
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView result(@RequestParam("message") String msg, ModelAndView mv) {
		
		logger.info("user add request");
		
		mv.addObject("message",msg);
		mv.setViewName("result");
		return mv;
	}
	
}