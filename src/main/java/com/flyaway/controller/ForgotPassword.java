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
public class ForgotPassword {
	
	@Autowired
	AdminService adminService;

	


	
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public ModelAndView forgotpassword() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("newcredentials", new Admin());
		mav.setViewName("forgotpassword");

		return mav;
	}
	
	
	
	
	
	
	@RequestMapping(value = "/resetpassword", method = RequestMethod.GET)
	public ModelAndView forgotpassword(@ModelAttribute Admin update) throws FAServiceException {
		ModelAndView mav=null;
		int n = adminService.UpdatePassword(update);
		
		System.out.println("inside controller" +n);

		if(n!=0){
			mav = new ModelAndView("login");
			mav.addObject("credentials", new Admin());

		}else {
			throw new FAServiceException();		

		}

		return mav;
	}

	@ExceptionHandler({FAServiceException.class, NullPointerException.class, SQLException.class})
    public ModelAndView handleException(Exception ex) {
        ModelAndView model = new ModelAndView("forgotpassword");
		model.addObject("newcredentials", new Admin());

        model.addObject("exception", ex.getMessage());
         
        return model;
    }


}
