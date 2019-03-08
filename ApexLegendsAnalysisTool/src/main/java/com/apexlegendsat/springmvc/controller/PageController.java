package com.apexlegendsat.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apexlegendsat.springmvc.entity.UserEntity;

@Controller
public class PageController {
	
	static Logger logger = LogManager.getLogger(PageController.class.getName());

	@RequestMapping(value = { "/analysis" }, method = RequestMethod.GET)
	public String getAnalysisPage() {
		logger.info("getting analysis page");
		return "analysis";
	}

	@RequestMapping(value = { "/legends" }, method = RequestMethod.GET)
	public String getLegendsPage() {
		logger.info("getting legends page");
		return "legends";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView getLoginPage(HttpServletRequest request) {
		logger.info("getting login page");
		
		ModelAndView modelView;
		UserEntity sessionUser = (UserEntity) request.getSession().getAttribute("user");
		
		if(sessionUser == null) {
			logger.error("User is not logged in.");
			modelView = new ModelAndView("login", "message", "please login");
		} else {
			logger.info("User is logged in.");
			modelView = new ModelAndView("weaponManager", "user", sessionUser);
		}
		
		return modelView;
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String getSignupPage() {
		logger.info("getting sign up page");
		return "signup";
	}

	@RequestMapping(value = { "/weaponmanager" }, method = RequestMethod.GET)
	public ModelAndView getWeaponManagerPage(HttpServletRequest request) {
		
		UserEntity sessionUser = (UserEntity) request.getSession().getAttribute("user");
		
		ModelAndView modelView;
		
		if(sessionUser == null) {
			logger.error("User attempted to access memberonly page");
			modelView = new ModelAndView("login", "Error", "LOGIN_ACCESS_ONLY");
		} else {
			logger.info("getting weapon manager page");
			modelView = new ModelAndView("weaponManager", "user", sessionUser);
		}
		
		return modelView;
	}

	@RequestMapping(value = { "/weapons" }, method = RequestMethod.GET)
	public String getWeaponsPage() {
		logger.info("getting weapons page");
		return "weapons";
	}
}