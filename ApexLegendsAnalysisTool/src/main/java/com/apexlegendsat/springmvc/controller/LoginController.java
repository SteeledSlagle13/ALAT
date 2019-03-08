package com.apexlegendsat.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.apexlegendsat.springmvc.entity.UserEntity;
import com.apexlegendsat.springmvc.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private final int TIME_OUT_SECONDS = 10 * 60;

	static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
		logger.info("checking user login");
		
		UserEntity user = userService.findByName(username);
		logger.info(user);
		
		if(user.getPassword().equals(password)) {
			request.getSession().setAttribute("user", user);
			request.getSession().setMaxInactiveInterval(TIME_OUT_SECONDS);
			return "redirect:/weaponmanager";
		} else {
			return "login";
		}
		
	}

}