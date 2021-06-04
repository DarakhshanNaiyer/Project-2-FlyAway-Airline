package com.flyaway.controller;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.Flights;
import com.flyaway.model.Location;
import com.flyaway.model.Search;
import com.flyaway.service.NewflightService;

@Controller
public class NewflightController {
	

	@Autowired
	public NewflightService newflightService;
	
	@RequestMapping(value = "/addnewflights", method = RequestMethod.GET)
	public ModelAndView addflight() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("newflight", new Flights());
		mav.setViewName("addflight");

		return mav;
	}
		@SuppressWarnings("unused")
		@RequestMapping(value = "/newflightinfo", method = RequestMethod.POST)
	public ModelAndView addnewflight(@ModelAttribute Flights newflight ) throws FAServiceException{
			
			ModelAndView mav = new ModelAndView();
			
		int n = newflightService.addflight(newflight);
		
		if(n!=0) {
			
			mav.addObject("message", "Successfully Added the flight!!");	
			mav.setViewName("welcome");
			
		}else {
			
			throw new FAServiceException();
		}
				
		return mav;
	}
		@ExceptionHandler({FAServiceException.class,NullPointerException.class,SQLException.class})
		public ModelAndView handleException(Exception ex) {
			ModelAndView model = new ModelAndView("addflight");
			model.addObject("newflight", new Flights());
			model.addObject("exception", ex.getMessage());

			return model;
		}
	}