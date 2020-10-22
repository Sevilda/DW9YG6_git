package com.meiit.webalk.reservation.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Floor;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.domain.Wing;
import com.meiit.webalk.reservation.domain.WingType;
import com.meiit.webalk.reservation.view.View;

public class ReservationService implements IReservationService {
	
	private BookingPerson bp;
	private List<Hotel> hotels=new ArrayList<Hotel>();
	private List<Reservation> reservations=new ArrayList<Reservation>();
	private List<BookingPerson> bookingPersons=new ArrayList<BookingPerson>();
	
	public void initData() {
		List<Room> rooms =new ArrayList<Room>();
		List<Wing> wingsEast =new ArrayList<Wing>();
		List<Floor> floors =new ArrayList<Floor>();
		
		rooms.add(0, new Room(1, 2, true, BigDecimal.valueOf(500), WingType.EAST));
		rooms.add(0, new Room(2, 3, true, BigDecimal.valueOf(1200), WingType.EAST));
		rooms.add(1, new Room(3, 4, false, BigDecimal.valueOf(1000), WingType.EAST));

		wingsEast.add(new Wing(WingType.EAST, rooms));

		floors.add(new Floor(1, 1, wingsEast));
		floors.add(new Floor(2, 1, wingsEast));

		hotels.add(new Hotel(1, "Hilton", "MiddleOf St. Nowh Ere 16.", 5, floors));
		
	}
	
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
		return this.bookingPersons.get(0);
	}

	public List<Hotel> findAllHotels() {
		return hotels;
	}


	public List<Reservation> findAllReservations() {
		return reservations;
	}


	public void saveReservation(Reservation reservation, View view) {
		bp=bookingPersons.get(0);
		if (reservation.getRoom().getPrice().compareTo(bp.getBalance())<0) {
		reservations.add(reservation);
		bp.setBalance(bp.getBalance().subtract(reservation.getRoom().getPrice()).multiply(BigDecimal.valueOf(0.9)));
		view.printReservationSaved();
		}
		else view.printNotEnoughBalance(bp);
	}

}
