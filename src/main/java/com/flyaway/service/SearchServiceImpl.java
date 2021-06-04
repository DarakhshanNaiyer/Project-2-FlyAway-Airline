package com.flyaway.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.flyaway.constant.ErrorConstants;
import com.flyaway.dao.SearchDao;
import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.Flights;
import com.flyaway.model.Location;
import com.flyaway.model.Search;

public class SearchServiceImpl implements SearchService {

	@Autowired
	SearchDao searchDao;

	@Override
	public List<Flights> validateSearch(Search search) throws FAServiceException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if(search.getSource().equals("None") || search.getSource().isEmpty()){
			throw new FAServiceException(ErrorConstants.EMPTY_SOURCE);

		}

		if(search.getDestination().equals("None") || search.getDestination().isEmpty()){
			throw new FAServiceException(ErrorConstants.EMPTY_DESTINATION);
		}

		if(search.getJourneyDate()==null || search.getJourneyDate().isEmpty()){
			throw new FAServiceException(ErrorConstants.EMPTY_JOURNEY_DATE);
		}

		try {
			Date d = sdf.parse(search.getJourneyDate()); //.parse mean changing into date format

			Date today= new Date();

			if(d.before(today)) {
				throw new FAServiceException(ErrorConstants.PAST_JOURNEY_DATE);

					
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if(search.getNumberOfSeats()>30) {
			throw new FAServiceException(ErrorConstants.MAX_CAPACITY);

		}
        
		System.out.println(" Inside service "+search.getNumberOfSeats());
		if(search.getNumberOfSeats()== null ||search.getNumberOfSeats().equals("0"))
		{
			throw new FAServiceException(ErrorConstants.EMPTY_NO_OF_SEATS);

		}
		if(search.getSource().equals(search.getDestination())) {
			throw new FAServiceException(ErrorConstants.SAME_PLACES);

		}
		

		List<Flights> flightlist = searchDao.validateSearch(search);

		return flightlist;
	}

	@Override
	public List<Location> locationList() throws FAServiceException {
		
		return searchDao.locationList();
	}

}
