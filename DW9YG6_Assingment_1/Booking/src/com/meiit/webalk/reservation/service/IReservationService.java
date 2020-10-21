package com.meiit.webalk.reservation.service;

import java.util.List;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;

public interface IReservationService {
	
	public void saveBookingPerson (BookingPerson bp);
	
	public BookingPerson findBookingPerson();
	
	public void saveReservation (Reservation reservation);
	
	public List<Hotel> findAllHotels();
	
	public List<Reservation> findAllReservations ();
	
	public void checkIn (Reservation reservation);
	
	public void checkOut(Reservation reservation);
	}


