package com.meiit.webalk.reservation.domain;

public class Room {

	private int number;
	private int beds;
	private boolean balcon;
	private int price;
	private WingType wing;
	
	public Room(int n, int b, boolean balc, int p, WingType w) {
		number=n;
		beds=b;
		balcon=balc;
		price=p;
		wing=w;
	}
	
	public Room() {}
	
	public String toString() {
		return "Number: " + number + "Beds: " + beds + "Price: " + price;
	}

	public static int getNumber(Room r) {
		return r.number;
	}

	public static void setNumber(int number, Room r) {
		r.number = number;
	}

	public static int getPrice(Room r) {
		return r.price;
	}

	public static void setPrice(int price, Room r) {
		r.price = price;
	}

	public static boolean isBalcon(Room r) {
		return r.balcon;
	}

	public static void setBalcon(boolean balcon, Room r) {
		r.balcon = balcon;
	}

	public static int getBeds(Room r) {
		return r.beds;
	}

	public static void setBeds(int beds, Room r) {
		r.beds = beds;
	}
	
}
