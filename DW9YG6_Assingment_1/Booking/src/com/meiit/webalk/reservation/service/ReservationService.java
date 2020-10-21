package com.meiit.webalk.reservation.service;

import java.util.ArrayList;
import java.util.List;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;

public class ReservationService implements IReservation {
	
	private BookingPerson bp;
	private List<Hotel> hotels=new ArrayList<Hotel>();
	private List<Reservation> reservations=new ArrayList<Reservation>();
	private List<BookingPerson> bookingPersons=new ArrayList<BookingPerson>();
	
	public void checkIn (Reservation res) {
		res.setActive(true);
	}
	
	public void checkOut (Reservation res) {
		res.setActive(false);
		res.setProcessed(true);
	}
	
	public void saveBookingPerson(BookingPerson bp) {
		bookingPersons.add(bp);
	}

	public BookingPerson findBookingPerson() {
		return bp;
	}

	public List<Hotel> findAllHotels() {
		return hotels;
	}


	public List<Reservation> findAllReservations() {
		return reservations;
	}


	public void saveReservation(Reservation res) {
		if (res.getRoom().getPrice()<bp.getBalance())
		reservations.add(res);	
		
	}



}
