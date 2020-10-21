package com.meiit.webalk.reservation.domain;

import java.util.List;

public class Wing {
	
	private int hotelId;
	private String description;
	private WingType wingType;
	private int floorNumber;
	private List<Room> rooms;
	
	public Wing (WingType wt, List<Room> rs) {
		wingType=wt;
		rooms=rs;		
	}

	public List<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public WingType getWingType() {
		return this.wingType;
	}

	public void setWingType(WingType wingType) {
		this.wingType = wingType;
	}
	
	public String toString() {
		return wingType.toString();
	}
	
}
