package com.meiit.webalk.reservation.domain;

import java.util.ArrayList;
import java.util.List;

//How redundant is this?

public class Floor {
	private int floorNumber;
	private int hotelId;
	private ArrayList<Wing> wings;
	
	public Floor (int fn, int hId, ArrayList<Wing> ws) {
		floorNumber=fn;
		hotelId=hId;
		wings=ws;
	}

	public static ArrayList<Wing> getWings(Floor f) {
		return f.wings;
	}

	public static void setWings(ArrayList<Wing> wings,Floor f) {
		f.wings = wings;
	}

	public static int getFloorNumber(Floor f) {
		return f.floorNumber;
	}

	public static void setFloorNumber(int floorNumber, Floor f) {
		f.floorNumber = floorNumber;
	}
	
	public String toString () {
		return floorNumber + wings.toString();
	}
}
