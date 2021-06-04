package com.flyaway.model;

public class Location {
	
	private Integer locId;
	private String locName;
	public Integer getLocId() {
		return locId;
	}
	public void setLocId(Integer locId) {
		this.locId = locId;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	public Location(Integer locId, String locName) {
		super();
		this.locId = locId;
		this.locName = locName;
	}
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
