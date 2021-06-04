package com.flyaway.constant;

public class QueryConstants {
	
	public static final String SEARCH_DISPLAY_QUERY = "select * from flight_master where source = ? and destination = ? and journeyDate = ?;";
	
	public static final String ADMIN_LOGIN = "select * from admin_master where username = ? and password = ?;";
	
	public static final String UPDATE_PASS = "update admin_master set password = ? where username = ?;";
	
	public static final String USER_REGISTER = "insert into users values(?,?,?,?,?,?,?)";
	
	public static final String LOCATION_QUERY = "select * from location_master;";

	public static final String DELETE_QUERY = "delete from flight_master where flightId=? ";
	
    public static final String ADD_QUERY="insert into flight_master values(?,?,?,?,?,?,?,?,?)";
}
