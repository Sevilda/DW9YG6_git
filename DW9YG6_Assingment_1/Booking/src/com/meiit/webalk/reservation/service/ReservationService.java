package com.meiit.webalk.reservation.service;

import java.util.ArrayList;
import java.util.List;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;

public class ReservationService implements IReservationService {
	
	private BookingPerson bp;
	private List<Hotel> hotels=new ArrayList<Hotel>();
	private List<Reservation> reservations=new ArrayList<Reservation>();
	private List<BookingPerson> bookingPersons=new ArrayList<BookingPerson>();
	
	public void checkIn (Reservation reservation) {
		reservation.setActive(true);
	}
	
	public void checkOut (Reservation reservation) {
		reservation.setActive(false);
		reservation.setProcessed(true);
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


	public void saveReservation(Reservation reservation) {
		if (reservation.getRoom().getPrice().compareTo(bp.getBalance())>0)
		reservations.add(reservation);
		bp.setBalance(bp.getBalance().subtract(reservation.getRoom().getPrice()));		
	}

}
