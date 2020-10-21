package com.meiit.webalk.reservation.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.meiit.webalk.reservation.Status;
import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Floor;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.domain.Wing;
import com.meiit.webalk.reservation.service.Reservation;
import com.meiit.webalk.reservation.service.ReservationService;

//Where is the provided interface?
public class View {

	//Please implement this method this is not acceptable based on the documentation
	public static BookingPerson readBookingPerson() {
		return null;
	}

	public void printWelcomeMessage(BookingPerson bp) {
		System.out.println("Welcome, " + bp.getName());
	}

	public void printBalance(BookingPerson bp) {
		System.out.println("Your current balance is " + bp.getBalance() + " " + bp.getCurrency() + ".");
	}

	//This should be in a helper class
	public void printRooms(ArrayList<Hotel> hotels) {
		int i = 0;
		for (Hotel h : hotels) {
			for (Floor f : h.getFloorList()) {
				// System.out.println(f.getFloorNumber(f));
				for (Wing w : f.getWings(f)) {
					// System.out.println(w.getWingType(w) +", "+ w.getRooms(w));
					for (Room r : w.getRooms(w)) {
						i++;
						System.out.println(i + ", Hotel name: " + h.getName() + ", Floor number: " + f.getFloorNumber(f)
								+ ", Wing: " + w.getWingType(w) + ", Room number: " + r.getNumber(r) + ", Beds: "
								+ r.getBeds(r) + ", Room Price: " + r.getPrice(r));
					}
				}
			}
		}
	}

	// no Room class yet.
	public Room selectRoom(ArrayList<Hotel> hotels, int chosen) {
		Room selectedR=null;
		int i=0;
		for (Hotel h : hotels) {
			for (Floor f : h.getFloorList()) {
				for (Wing w : f.getWings(f)) {
					for (Room r : w.getRooms(w)) {
						i++; 
						if (chosen == i) {
							selectedR = r;
							break;
						}
					}
				}
			}
		}
		return selectedR;

	}

	public void printReservationSaved(ReservationService res) {
		System.out.println(res.toString());
	}

	public void printNotEnoughBalance(BookingPerson bp) {
		System.out.println("You do not have enough balance,please choose another room");
		printBalance(bp);

	}

	//Please follow the documentation 
	public void printCheckIn(ReservationService res) {
		if (res.getStatus(res) == Status.valueOf("ACTIVE"))
			//This is not part of the expected output
			System.out.println("Ready to check in!");
		else if (res.getStatus(res) == Status.valueOf("BOOKED"))
			//This is not part of the expected output
			System.out.println("Your check in will be available soon TM");

	}

	public void printCheckOut(BookingPerson bp, ReservationService res) {
		//This is not part of the expected output
		if (res.getStatus(res) == Status.valueOf("PROCESSED")) {
			System.out.println("Your checkout has been processed. \n" + "Your new balance is " + bp.getBalance());
		}
	}

	public void PrintReservations(ArrayList<ReservationService> reservations) {
		System.out.println("Your reservations: ");
		for (ReservationService r : reservations)
			System.out.println(r.toString());
	}
}
//ArrayList not part of the documentation
