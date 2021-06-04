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
import com.flyaway.model.Flights;
import com.flyaway.model.User;
import com.flyaway.service.UserService;

@Controller
public class RegistrationController {
	@Autowired
	public UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", new User());
		mav.setViewName("register");

		return mav;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute User user) throws FAServiceException {

		int n = userService.register(user);
		ModelAndView mav = new ModelAndView();
		
      if(n!=0) {
		
			mav.setViewName("payment");
			
		}else {
			
			throw new FAServiceException();
		}

		return mav;
	}
	
	@RequestMapping(value = "/paymentProcess", method = RequestMethod.GET)
	public ModelAndView paymentProcess() {


		return new ModelAndView("paymentSuccessful");
	}
	
	@ExceptionHandler({FAServiceException.class,NullPointerException.class,SQLException.class})
	public ModelAndView handleException(Exception ex) {
		ModelAndView model = new ModelAndView("register");
		model.addObject("user", new User());
		model.setViewName("register");

		return model;
	}
	
}
