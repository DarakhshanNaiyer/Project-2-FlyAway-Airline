package com.flyaway.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.flyaway.constant.QueryConstants;
import com.flyaway.exceptions.FAServiceException;
import com.flyaway.model.Flights;
import com.flyaway.model.Location;
import com.flyaway.model.Search;

public class SearchDaoImpl implements SearchDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Flights> validateSearch(Search search) throws FAServiceException{

		List<Flights> flightsList = new ArrayList<Flights>();
		
		String src = null;
		String dst = null;

		System.out.println("In dao "+search.getDestination());
		System.out.println("In dao "+search.getSource());

		Map<Integer, String> locationMap = new TreeMap<Integer, String>();
		
		locationMap.put(1,"bangalore");
		locationMap.put(2,"delhi");
		locationMap.put(3,"jammu");
		locationMap.put(4,"manali");

		// using iterators
        Iterator<Map.Entry<Integer, String>> itr = locationMap.entrySet().iterator();
         
        while(itr.hasNext())
        {
             Entry<Integer, String> entry = itr.next();
             if(entry.getKey()==(Integer.parseInt(search.getSource()))) {
            	 src = entry.getValue();
            	 System.out.println("------"+entry.getKey()+"-------"+search.getSource());
        }
             if(entry.getKey().equals(Integer.parseInt(search.getDestination()))) {
             	 dst = entry.getValue();
         }
    }
        
        
        
        System.out.println("Insode sao " +src+ "===="+dst);
		RowMapper<Flights> rowMapper = new  RowMapper<Flights>() {

			@Override
			public Flights mapRow(ResultSet rs, int rowNum) throws SQLException {

				Integer flightId = rs.getInt("flightId");
				String airlineName = rs.getString("airlineName");
				String departureTime = rs.getString("departureTime");
				String arrivalTime = rs.getString("arrivalTime");
				String source = rs.getString("source");
				String destination = rs.getString("destination");	
				String journeyDate = rs.getString("journeyDate");
				Double fare = Double.valueOf(search.getNumberOfSeats())
						*rs.getDouble("fare");
				Integer availableSeats =rs.getInt("availableSeats");

				Flights flight = new Flights(flightId, airlineName, source, 
						departureTime, journeyDate, 
						destination, arrivalTime, fare, availableSeats);

				flightsList.add(flight);

				return flight;
			}


		};
		  System.out.println("dao"+flightsList);

		return jdbcTemplate.query(QueryConstants.SEARCH_DISPLAY_QUERY, rowMapper,
			new Object[] {src.toLowerCase(), dst.toLowerCase(), search.getJourneyDate()});
	}
	
	

	@Override
	public List<Location> locationList() throws FAServiceException {
		List<Location> locationList = new ArrayList<Location>();

		RowMapper<Location> rowMapper = new  RowMapper<Location>() {

			@Override
			public Location mapRow(ResultSet rs, int rowNum) throws SQLException {

				Integer locId = rs.getInt("locId");
				String locName = rs.getString("locName");
				
				Location location = new Location(locId, locName);

				locationList.add(location);
				return location;	
				
			}
		};
		  System.out.println("dao"+locationList);

		return jdbcTemplate.query(QueryConstants.LOCATION_QUERY, rowMapper);
	}




}
