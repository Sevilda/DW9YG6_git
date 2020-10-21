package com.meiit.webalk.reservation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Currency;
import com.meiit.webalk.reservation.domain.Floor;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.domain.Wing;
import com.meiit.webalk.reservation.domain.WingType;
import com.meiit.webalk.reservation.service.ReservationService;
import com.meiit.webalk.reservation.view.View;

public class App {
	//use private Static is not need in here, also follow the documentation most of this field shoud not be here
	static BookingPerson bp;
	static ReservationService res;
	static App app;
	static View view;
	static Scanner sc;

	//Use List<> based on the documentation
	static ArrayList<Room> rooms = new ArrayList<Room>();
	static ArrayList<Wing> wings = new ArrayList<Wing>();
	static ArrayList<Floor> floors = new ArrayList<Floor>();
	static ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	static ArrayList<ReservationService> reservations = new ArrayList<ReservationService>();

	public static void main(String[] args) {
		//Scanner shoud be in the view
		sc = new Scanner(System.in);
		
		rooms.add(0, new Room(1, 2, true, 500, WingType.EAST));
		rooms.add(1, new Room(6, 4, false, 1000, WingType.EAST));

		wings.add(new Wing(WingType.EAST, rooms));

		floors.add(new Floor(1, 1, wings));
		floors.add(new Floor(2, 1, wings));

		hotels.add(new Hotel(1, "Hilton", "MiddleOf St. Nowh Ere 16.", 5, floors));
		//Thats good with this you dont need to use static in the service and view
		-----
		res = new ReservationService();
		view = new View();
		app = new App(res, view);
		---
	}

	public App(ReservationService res, View view) {
		try {
			createBookingPerson();
			view.printWelcomeMessage(bp);
			view.printBalance(bp);
			book();
			view.PrintReservations(reservations);
			checkIn();
			checkOut();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createBookingPerson() {
		//All System.out.println and  sc.nextLine().toString(); should be in the view
		System.out.println("What is your name?");
		String name = sc.nextLine().toString();
		System.out.println("What is your account balance?");
		int balance = Integer.parseInt(sc.nextLine());
		System.out.println("What is your currency type?");
		Currency curr = (Currency.valueOf(sc.nextLine().toUpperCase()));
		bp = new BookingPerson(name, balance, curr);
	}

	public void book() {
		//All System.out.println and  sc.nextLine().toString(); should be in the view
		boolean done=false;
		while (!done) {
		
		System.out.println(
				"Where would you like to book? \nChoose a number of the desired room, or press q to quit the selection.");
		view.printRooms(hotels);

		char c = sc.next().charAt(0);
		if (c=='q') {
				System.out.println("Quit booking. ");
				done=true;
			}
		else if (Character.isDigit(c)){
				int chosen=Integer.parseInt(String.valueOf(c));
				Room attemptRes = view.selectRoom(hotels, chosen);
				
				if (attemptRes.getPrice(attemptRes)<=bp.getBalance()) {
					res = new ReservationService(hotels.get(0), bp.getCurrency(), attemptRes.getPrice(attemptRes), attemptRes);
					view.printReservationSaved(res);					
					//make reservation
					res.setStatus(Status.valueOf("BOOKED"), res);
					reservations.add(res);
					bp.setBalance(bp.getBalance()-attemptRes.getPrice(attemptRes));
				}
				else view.printNotEnoughBalance(bp);
			}
		}
	}

	public void checkIn() {
		Calendar currentDay = Calendar.getInstance();
		Calendar bookedDayFrom = Calendar.getInstance();

		currentDay.setTime(new Date());
		bookedDayFrom.setTime(res.getFromDate());
		// System.out.println(res.getFromDate());

		if (currentDay.get(Calendar.DAY_OF_YEAR) == bookedDayFrom.get(Calendar.DAY_OF_YEAR)) {
			res.checkIn(res);
			view.printCheckIn(res);
		} else if (currentDay.get(Calendar.DAY_OF_YEAR) >= bookedDayFrom.get(Calendar.DAY_OF_YEAR)) {
			view.printCheckIn(res);
		}

	}

	public void checkOut() {
		res.checkOut(res);
		view.printCheckOut(bp, res);
	}


}
//Logic must be contained in service
