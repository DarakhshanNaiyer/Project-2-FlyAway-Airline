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
import com.flyaway.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	SearchService searchService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchFlight() throws FAServiceException {
		ModelAndView model = new ModelAndView();

		List<Location> locationList = searchService.locationList();
		model.addObject("locationList", locationList);
		model.addObject("availableFlights", new Search());
		model.setViewName("search");

		return model;
	}

	@RequestMapping(value = "/searchProcess", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute Search search) throws FAServiceException {

		System.out.println("In con"+search.getDestination());
		List<Flights> flightsList = searchService.validateSearch(search);
		System.out.println("cont"+flightsList);

		ModelAndView model= new ModelAndView();
		if(flightsList!=null) {
			model.addObject("flightsList", flightsList);
			model.setViewName("searchresult");
		}else {
			throw new FAServiceException();
		}

		return model;
	}

	@SuppressWarnings("unlikely-arg-type")
	@ExceptionHandler({FAServiceException.class, NullPointerException.class, SQLException.class, NumberFormatException.class})
	public ModelAndView handleException(Exception ex) {
		ModelAndView model = new ModelAndView("search");

		model.addObject("availableFlights", new Search());

		List<Location> locationList;
		try {
			locationList = searchService.locationList();

			model.addObject("locationList", locationList);

		} catch (FAServiceException e) {
			e.printStackTrace();
		}

		model.addObject("exception", ex.getMessage());

		return model;
	}




}
