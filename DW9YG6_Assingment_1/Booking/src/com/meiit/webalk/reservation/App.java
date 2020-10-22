package com.meiit.webalk.reservation;

import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.service.ReservationService;
import com.meiit.webalk.reservation.view.View;

public class App {

	ReservationService reservationService;
	App app;
	View view;

	public static void main(String[] args) {

		try {
			App app = new App(new ReservationService(), new View());
			app.createBookingPerson();
			app.book();
			app.checkIn();
			app.checkOut();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public App(ReservationService reservationService, View view) {
		this.reservationService = reservationService;
		this.view = view;
		reservationService.initData();
	}

	public void createBookingPerson() {
		reservationService.saveBookingPerson(view.readBookingPerson());
	}

	public void book() {
		Room r = null;
		while (r == null) {
			r = view.selectRoom(reservationService.findAllHotels());
			System.out.println(r==null);
			if (r != null) {
				Reservation newReservation = new Reservation(reservationService.findBookingPerson().getName(), r);
				reservationService.saveReservation(newReservation, view);
				//TODO loop properly
			}
		};

	}

	public void checkIn() {
		view.printCheckIn();
	}

	public void checkOut() {
		view.printCheckOut();
		view.printBalance(reservationService.findBookingPerson());
	}

}