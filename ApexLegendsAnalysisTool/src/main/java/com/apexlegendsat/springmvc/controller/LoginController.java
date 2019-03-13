package com.apexlegendsat.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apexlegendsat.springmvc.service.UserService;
import com.apexlegendsat.springmvc.view.UserView;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private final int TIME_OUT_MINUTES = 10;
	private final int TIME_OUT_SECONDS = TIME_OUT_MINUTES * 60;

	static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
		logger.info("checking user login");
		
		UserView userView = userService.findByName(username);
		
		if(userView.getPassword().equals(password)) {
			request.getSession().setAttribute("user", userView);
			request.getSession().setMaxInactiveInterval(TIME_OUT_SECONDS);
			return "redirect:/weaponmanager";
		} else {
			return "login";
		}
		
	}

}