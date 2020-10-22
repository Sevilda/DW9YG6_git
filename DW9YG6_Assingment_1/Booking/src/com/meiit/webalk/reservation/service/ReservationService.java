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
		List<Wing> wingsNorth =new ArrayList<Wing>();
		List<Floor> floors =new ArrayList<Floor>();
		
		rooms.add(0, new Room(1, 2, true, BigDecimal.valueOf(500), WingType.EAST));
		rooms.add(1, new Room(2, 3, true, BigDecimal.valueOf(1200), WingType.EAST));
		rooms.add(2, new Room(3, 4, false, BigDecimal.valueOf(1000), WingType.EAST));

		rooms.add(3, new Room(4, 4, false, BigDecimal.valueOf(750), WingType.NORTH));
		rooms.add(4, new Room(5, 3, true, BigDecimal.valueOf(1000), WingType.NORTH));
		rooms.add(5, new Room(6, 4, true, BigDecimal.valueOf(1600), WingType.NORTH));
		
		//
		wingsEast.add(new Wing(WingType.EAST, rooms.subList(0, 3)));
		wingsNorth.add(new Wing(WingType.NORTH, rooms.subList(3, 6)));
	

		floors.add(new Floor(1, 1, wingsEast));
		floors.add(new Floor(2, 1, wingsNorth));

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
		reservations.add(reservation);
		bp.setBalance(bp.getBalance().subtract(reservation.getRoom().getPrice()).multiply(BigDecimal.valueOf(0.9)));
		view.printReservationSaved();
	}

}
