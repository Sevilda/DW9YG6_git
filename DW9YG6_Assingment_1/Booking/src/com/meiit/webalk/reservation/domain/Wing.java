package com.meiit.webalk.reservation.domain;

import java.util.ArrayList;

public class Wing {
	
	private int hotelId;
	private String description;
	private WingType wingType;
	private int floorNumber;
	private ArrayList<Room> rooms;
	
	public Wing (WingType wt, ArrayList<Room> rs) {
		wingType=wt;
		rooms=rs;		
	}

	public static ArrayList<Room> getRooms(Wing w) {
		return w.rooms;
	}

	public static void setRooms(ArrayList<Room> rooms, Wing w) {
		w.rooms = rooms;
	}

	public WingType getWingType(Wing w) {
		return w.wingType;
	}

	public void setWingType(WingType wingType, Wing w) {
		w.wingType = wingType;
	}
	
	public String toString() {
		return wingType.toString();
	}
	
}
