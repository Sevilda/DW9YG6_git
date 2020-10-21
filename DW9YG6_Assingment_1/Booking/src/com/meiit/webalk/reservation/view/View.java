package com.meiit.webalk.reservation.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Currency;
import com.meiit.webalk.reservation.domain.Floor;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.domain.Wing;
import com.meiit.webalk.reservation.service.ReservationService;

public class View implements IView {
	Scanner sc = new Scanner(System.in);

	public BookingPerson readBookingPerson() {
		BookingPerson bp;
		System.out.println("What is your name?");
		String name = sc.nextLine().toString();
		System.out.println("What is your account balance?");
		BigDecimal balance = BigDecimal.valueOf(Long.valueOf(sc.nextLine()));
		System.out.println("What is your currency type?");
		Currency curr = (Currency.valueOf(sc.nextLine().toUpperCase()));
		bp = new BookingPerson(name, balance, curr);
		printWelcomeMessage(bp);
		printBalance(bp);
		return bp;
	}

	public void printWelcomeMessage(BookingPerson bp) {
		System.out.println("Welcome, " + bp.getName());
	}

	public void printBalance(BookingPerson bp) {
		System.out.println("Your current balance is " + bp.getBalance() + " " + bp.getCurrency() + ".");
	}

	public void printRooms(List<Hotel> hotels) {

		System.out.println(
				"Where would you like to book? \nChoose a number of the desired room, or press q to quit the selection.");
		int i = 0;
		for (Hotel h : hotels) {
			for (Floor f : h.getFloorList()) {
				for (Wing w : f.getWings()) {
					for (Room r : w.getRooms()) {
						i++;
						System.out.println(i + ", Hotel name: " + h.getName() + ", Floor number: " + f.getFloorNumber()
								+ ", Wing: " + w.getWingType() + ", Room number: " + r.getNumber() + ", Beds: "
								+ r.getBeds() + ", Room Price: " + r.getPrice());
					}
				}
			}
		}
	}
//TODO
	/*
	 * if (attemptRes.getPrice(attemptRes)<=bp.getBalance()) { res = new
	 * Reservation(hotels.get(0), bp.getCurrency(), attemptRes.getPrice(attemptRes),
	 * attemptRes); view.printReservationSaved(res); //make reservation
	 * res.setStatus(Status.valueOf("BOOKED"), res); reservations.add(res);
	 * bp.setBalance(bp.getBalance()-attemptRes.getPrice(attemptRes)); } else
	 * view.printNotEnoughBalance(bp); }
	 */

	public Room selectRoom(List<Hotel> hotels) {
		Room room = null;

		printRooms(hotels);
		char c = sc.next().charAt(0);
		if (c == 'q') {
			System.out.println("Quit booking. ");
			return null;
		} else if (Character.isDigit(c)) {
			int chosen = Integer.parseInt(String.valueOf(c));

			int i = 0;
			for (Hotel h : hotels) {
				for (Floor f : h.getFloorList()) {
					for (Wing w : f.getWings()) {
						for (Room r : w.getRooms()) {
							i++;
							if (chosen == i) {
								room = r;
								break;
							}
						}
					}
				}
			}

		}
		return room;
	}

	public void printReservationSaved() {
		System.out.println("Reservation successfully saved");
	}

	public void printNotEnoughBalance(BookingPerson bp) {
		System.out.println("You do not have enough balance,please choose another room");
		printBalance(bp);

	}

	public void printCheckIn() {
		System.out.println("Check In");
	}

	public void printCheckOut() {
		System.out.println("Check out! \nSurprise, you are our 100th guest! You got a 10% refund \n");
	}

	public void PrintReservations(List<Reservation> reservations) {
		System.out.println("Your reservations: ");
		for (Reservation r : reservations)
			System.out.println(r.toString());
	}

}