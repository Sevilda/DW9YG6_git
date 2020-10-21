package com.meiit.webalk.reservation.service;

import java.util.ArrayList;
import java.util.Date;

import com.meiit.webalk.reservation.Status;
import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Currency;
import com.meiit.webalk.reservation.domain.Hotel;

// This is not a correct interface
// Dont modify the provided interface, Use the provided nameing!!
public interface Reservation {
	//Do not use statefull interface!
	//The expectation is not bad but this is should be in the implementation
	------------
	Reservation res=null;
	static ArrayList<Hotel> hotels=new ArrayList<Hotel>();
	static ArrayList<Reservation> reservations=new ArrayList<Reservation>();
	----------------
	
	//Interface is not contains epmty methods only the method signature!
	//static is not part of the original interface
	public static void saveBookingPerson (BookingPerson bp) {}
	
	//Never put implementation in the interface
	public static BookingPerson findBookingPerson() {
		BookingPerson bp=null;
		return bp;
	}
	
	//Based on the doc you need to use List
	public static ArrayList<Hotel> findAllHotels () {
		return hotels;
	}
	
	public static void saveReservation (Reservation res) {
		reservations.add(res);
	}
	
	//same
	public static ArrayList<Reservation> findAllReservations () {
		return reservations;
	}
	
	public static void checkIn () {
	}
	
	public static void checkOut () {}
	
}


