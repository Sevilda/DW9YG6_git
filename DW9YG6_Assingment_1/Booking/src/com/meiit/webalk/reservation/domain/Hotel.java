package com.meiit.webalk.reservation.domain;

import java.util.List;

public class Hotel {
	//Id is not part of the task! YAGNI
	private int id; 
	private String name;
	private String address;
	private int stars;
	//Maybe private??? or something?
	List<Floor> floorList;
	
	public List<Floor> getFloorList() {
		return floorList;
	}

	public void setFloorList(List<Floor> floorList) {
		this.floorList = floorList;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hotel(int id, String n, String a, int s, List<Floor> floors) {
		this.id=id;
		this.name=n;
		this.address=a;
		this.stars=s;
		this.floorList=floors;
	}
	
	

	@Override
	public String toString() {
		return id + ", Hotel name: " + name + " stars: " + stars;
	}
	
	

}
