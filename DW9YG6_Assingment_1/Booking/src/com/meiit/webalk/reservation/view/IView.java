package com.meiit.webalk.reservation.view;

import java.util.List;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;

public interface IView {

	public BookingPerson readBookingPerson();

	public void printWelcomeMessage(BookingPerson bp);

	public void printBalance(BookingPerson bp);

	public void printRooms(List<Hotel> hotels);

	public Room selectRoom(List<Hotel> hotels);

	public void PrintReservations(List<Reservation> reservations);

	public void printNotEnoughBalance(BookingPerson bp);

	public void printCheckIn();

	public void printCheckOut();

}
