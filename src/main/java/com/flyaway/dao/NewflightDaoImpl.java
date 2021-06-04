package com.flyaway.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.flyaway.constant.QueryConstants;
import com.flyaway.model.Flights;

public class NewflightDaoImpl implements NewflightDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addflight(Flights newflight) {
		
		return jdbcTemplate.update(QueryConstants.ADD_QUERY, new Object[] {newflight.getFlightId(),
				newflight.getAirlineName().toLowerCase(),newflight.getSource().toLowerCase(), 
				newflight.getDestination().toLowerCase(), 
				newflight.getDepartureTime(), newflight.getJourneyDate(),
				newflight.getArrivalTime(), newflight.getFare(), 
				newflight.getAvailableSeats()});
	}

}
