package com.meiit.webalk.reservation.domain;

import java.util.ArrayList;

public class Hotel {
	
	private static int id; 
	private static String name;
	private static String address;
	private static int stars;
	ArrayList<Floor> floorList;
	
	public ArrayList<Floor> getFloorList() {
		return floorList;
	}

	public void setFloorList(ArrayList<Floor> floorList) {
		this.floorList = floorList;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Hotel.name = name;
	}

	public Hotel(int id, String n, String a, int s, ArrayList<Floor> floors) {
		Hotel.id=id;
		name=n;
		address=a;
		stars=s;
		floorList=floors;
	}
	
	

	@Override
	public String toString() {
		return id + ", Hotel name: " + name + " stars: " + stars;
	}
	
	

}
