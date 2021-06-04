package com.flyaway.controller;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.Admin;
import com.flyaway.service.AdminService;

@Controller
public class LoginController {

	@Autowired
	AdminService adminService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("credentials", new Admin());
		mav.setViewName("login");

		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@ModelAttribute Admin login) throws FAServiceException  {
		ModelAndView mav = new ModelAndView();
		
		Admin admin = adminService.validateAdmin(login);

		if (admin  != null) {
			mav = new ModelAndView("welcome");
			mav.addObject("username", admin.getUsername());
		} else {
			throw new FAServiceException();		
		}

		return mav;
	}

	
	@ExceptionHandler({FAServiceException.class,NullPointerException.class,SQLException.class})
    public ModelAndView handleException(Exception ex) {
        ModelAndView model = new ModelAndView("login");
		model.addObject("credentials", new Admin());

        model.addObject("exception", ex.getMessage());
         
        return model;
    }
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView("home");

		return mav;
	}

}
