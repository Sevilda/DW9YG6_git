package com.meiit.webalk.reservation.domain;

import java.util.Date;
//Static is not need
public class BookingPerson extends User {

	//missing field
	private static int accountNumber; // bank number? id? //not id 
	private static int balance; //Wrong type
	private static Date birth;  //Wrong type
	private static Currency curr;

	//What is this?? inheritence?? OOP??
	private static String email;
	private static String pw;

	public BookingPerson(String n, int b, Currency c) {
		setName(n);
		setBalance(b);
		setCurrency(c);
	}
	
	public String toString() {
		return ("nev: " + name + " email " + email + "curr: " + curr);
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	};
	
	public Currency getCurrency() {
		return curr;
	}

	public void setCurrency(Currency curr) {
		this.curr = curr;
	};
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
