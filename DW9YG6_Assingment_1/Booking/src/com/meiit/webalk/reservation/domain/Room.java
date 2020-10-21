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

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isBalcon() {
		return this.balcon;
	}

	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}

	public int getBeds() {
		return this.beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}
	
}
