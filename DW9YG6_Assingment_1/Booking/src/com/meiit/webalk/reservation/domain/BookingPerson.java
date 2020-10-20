package com.meiit.webalk.reservation.domain;

import java.util.Date;

public class BookingPerson extends User {

	private static int accountNumber; // bank number? id?
	private static int balance;
	private static Date birth;
	private static Currency curr;

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

	public static int getBalance() {
		return balance;
	}

	public static void setBalance(int balance) {
		BookingPerson.balance = balance;
	};
	
	public static Currency getCurrency() {
		return curr;
	}

	public static void setCurrency(Currency curr) {
		BookingPerson.curr = curr;
	};
	
	private static String name;
	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		BookingPerson.name = name;
	}
}
