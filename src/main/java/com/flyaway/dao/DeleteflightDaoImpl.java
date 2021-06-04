package com.flyaway.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.flyaway.constant.QueryConstants;
import com.flyaway.model.Flights;

public class DeleteflightDaoImpl implements DeleteflightDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int deleteflight(Flights deleteflight) {

		return jdbcTemplate.update(QueryConstants.DELETE_QUERY, new Object[] 
				{deleteflight.getFlightId()});
	}

}
