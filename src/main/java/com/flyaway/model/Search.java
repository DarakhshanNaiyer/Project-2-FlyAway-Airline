package com.flyaway.model;

public class Search {

	String source;
	String destination;
	String journeyDate;
	Integer numberOfSeats;
	
	public Search() {
		
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Search(String source, String destination, String journeyDate, Integer numberOfSeats) {
		super();
		this.source = source;
		this.destination = destination;
		this.journeyDate = journeyDate;
		this.numberOfSeats = numberOfSeats;
	}
	
	
}
