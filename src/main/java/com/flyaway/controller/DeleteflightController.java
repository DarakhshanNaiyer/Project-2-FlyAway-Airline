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
import com.flyaway.service.DeleteflightService;

@Controller
public class DeleteflightController {
	
	@Autowired
	public DeleteflightService deleteflightService;
	
	@RequestMapping(value = "/deleteflight", method = RequestMethod.GET)
	public ModelAndView delete() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("removeflight", new Flights());
		mav.setViewName("deleteflight");

		return mav;
}
	@RequestMapping(value = "/deleteflightinfo", method = RequestMethod.POST)
	public ModelAndView deleteflight(@ModelAttribute Flights deleteflight ) throws FAServiceException{
		
		ModelAndView mav = new ModelAndView();
		
	   int n= deleteflightService.deleteflight(deleteflight);
	   
	   System.out.println("inside controller (n)"+n);
	   
	  if (n!=0) {
		mav.addObject("message", "Successfully deleted the flight!!");
		mav.setViewName("welcome");
	  }else {
		   System.out.println("inside else (n)"+n);

		  throw new FAServiceException();
	  }
	  
		return mav;
	}
	
	@ExceptionHandler({FAServiceException.class,NullPointerException.class,SQLException.class})
	public ModelAndView handleException(Exception ex) {
		ModelAndView model = new ModelAndView("deleteflight");
		model.addObject("removeflight", new Flights());
		model.addObject("exception", ex.getMessage());

		return model;
	}
}