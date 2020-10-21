package com.meiit.webalk.reservation.service;

import java.util.List;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;

public interface IReservation {
	
	public void saveBookingPerson (BookingPerson bp);
	
	public BookingPerson findBookingPerson();
	
	public void saveReservation (Reservation res);
	
	public List<Hotel> findAllHotels();
	
	public List<Reservation> findAllReservations ();
	
	public void checkIn (Reservation res);
	
	public void checkOut(Reservation res);
	}


