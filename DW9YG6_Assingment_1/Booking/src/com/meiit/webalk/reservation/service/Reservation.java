package com.meiit.webalk.reservation.service;

import java.util.ArrayList;
import java.util.Date;

import com.meiit.webalk.reservation.Status;
import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Currency;
import com.meiit.webalk.reservation.domain.Hotel;

public interface Reservation {
	
	Reservation res=null;
	static ArrayList<Hotel> hotels=new ArrayList<Hotel>();
	static ArrayList<Reservation> reservations=new ArrayList<Reservation>();
	
	public static void saveBookingPerson (BookingPerson bp) {}
	
	public static BookingPerson findBookingPerson() {
		BookingPerson bp=null;
		return bp;
	}
	
	public static ArrayList<Hotel> findAllHotels () {
		return hotels;
	}
	
	public static void saveReservation (Reservation res) {
		reservations.add(res);
	}
	
	public static ArrayList<Reservation> findAllReservations () {
		return reservations;
	}
	
	public static void checkIn () {
	}
	
	public static void checkOut () {}
	
}


