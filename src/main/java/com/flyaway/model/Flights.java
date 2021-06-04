package com.flyaway.model;

public class Flights {

	private Integer flightId;
	private String airlineName;
	private String source;
	private String destination;
	private String departureTime;
	private String journeyDate;
	private String arrivalTime;
	private Double fare;
	private Integer availableSeats;
	
			
	public Flights() {
		
	}
	
	public Flights(Integer flightId) {
		super();
		this.flightId = flightId;
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
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

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Flights(Integer flightId, String airlineName, String source, String destination, String departureTime,
			String journeyDate, String arrivalTime, Double fare, Integer availableSeats) {
		super();
		this.flightId = flightId;
		this.airlineName = airlineName;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.journeyDate = journeyDate;
		this.arrivalTime = arrivalTime;
		this.fare = fare;
		this.availableSeats = availableSeats;
	}

	@Override
	public String toString() {
		return "Flights [flightId=" + flightId + ", airlineName=" + airlineName + ", source=" + source
				+ ", destination=" + destination + ", departureTime=" + departureTime + ", journeyDate=" + journeyDate
				+ ", arrivalTime=" + arrivalTime + ", fare=" + fare + ", availableSeats=" + availableSeats + "]";
	}
	
}
