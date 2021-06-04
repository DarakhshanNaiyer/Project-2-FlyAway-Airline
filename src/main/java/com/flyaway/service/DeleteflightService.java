package com.flyaway.service;

import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.Flights;

public interface DeleteflightService {

	  public int deleteflight(Flights deleteflight) throws FAServiceException;

}
