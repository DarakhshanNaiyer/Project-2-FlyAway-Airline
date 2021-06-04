package com.flyaway.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.flyaway.constant.ErrorConstants;
import com.flyaway.dao.NewflightDao;
import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.Flights;

public class NewflightServiceImpl implements NewflightService {

	@Autowired
	public NewflightDao newflightDao;

	@Override
	public int addflight(Flights newflight) throws FAServiceException {

		if (newflight.getFlightId() == 0 || newflight.getFlightId()==null) {
			throw new FAServiceException(ErrorConstants.EMPTY_FLIGHTID);
		}
		if (newflight.getArrivalTime() == null || newflight.getArrivalTime().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_FLIGHTTIME);
		}
		if (newflight.getDepartureTime() == null || newflight.getDepartureTime().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_FLIGHTTIME);
		}

		if (newflight.getSource() == null || newflight.getSource().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_SOURCE);
		}
		if (newflight.getDestination()== null || newflight.getDestination().isEmpty()) {
			throw new FAServiceException(ErrorConstants.EMPTY_DESTINATION);
		}
		if (newflight.getFare()== 0.0 || newflight.getFare()==null) {
			throw new FAServiceException(ErrorConstants.EMPTY_FARE);
		}
		if (newflight.getAvailableSeats()== 0 || newflight.getAvailableSeats()==null) {
			throw new FAServiceException(ErrorConstants.EMPTY_NO_OF_SEATS);
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if(newflight.getJourneyDate()==null || newflight.getJourneyDate().isEmpty()){
			throw new FAServiceException(ErrorConstants.EMPTY_JOURNEY_DATE);
		}

		try {
			Date d = sdf.parse(newflight.getJourneyDate()); //.parse mean changing into date format

			Date today= new Date();

			if(d.before(today)) {
				throw new FAServiceException(ErrorConstants.PAST_JOURNEY_DATE);
			}

		} catch (ParseException e) {
			System.out.println("You can not choose previous dates!");

		}

		return newflightDao.addflight(newflight);
	}
}
