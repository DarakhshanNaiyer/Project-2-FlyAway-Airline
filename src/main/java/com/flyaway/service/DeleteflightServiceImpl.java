package com.flyaway.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.flyaway.constant.ErrorConstants;
import com.flyaway.dao.DeleteflightDao;
import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.Flights;

public class DeleteflightServiceImpl implements DeleteflightService {

	@Autowired
	  public DeleteflightDao deleteflightDao;
	 
	@Override
	public int deleteflight(Flights deleteflight) throws FAServiceException {
		
		System.out.println("Inside ServiceIMPL "+deleteflight.getFlightId());
		
		if (deleteflight.getFlightId() == 0 || deleteflight.getFlightId() == null) {
		
			throw new FAServiceException(ErrorConstants.EMPTY_FLIGHTID);
		}
		       	
	    return deleteflightDao.deleteflight(deleteflight);
	}
		
}
