package com.meiit.webalk.reservation.domain;

import java.util.List;


public class Floor {
	private int floorNumber;
	private List<Wing> wings;
	
	public Floor (int fn, List<Wing> ws) {
		floorNumber=fn;
		wings=ws;
	}

	public List<Wing> getWings() {
		return this.wings;
	}

	public  void setWings(List<Wing> wings) {
		this.wings = wings;
	}

	public int getFloorNumber() {
		return this.floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	
	public String toString () {
		return floorNumber + wings.toString();
	}
}
