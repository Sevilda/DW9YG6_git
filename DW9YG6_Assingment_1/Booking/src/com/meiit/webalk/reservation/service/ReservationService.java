package com.meiit.webalk.reservation.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.meiit.webalk.reservation.Status;
import com.meiit.webalk.reservation.domain.Currency;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Room;

public class ReservationService implements Reservation {
	
	//Any way this is also a useless declaration....
	-------------------
	private Status status; 
	//booked, active, processed - don't see the point in using booleans when we can use enums for the same purpose. 
	//Why are you use enum when the actual status can defined in 2 state,
	//Ask before you do a similar comments like this.
	private Hotel hotel;
	private Room room;
	private Date fromDate = new Date();
	private Date toDate = fromDate;
	private Currency curr;
	//BigDecimal requvired...  
	private int amount;
	private Reservation res;
	----------------------
	//Ask, and read documentation before you make arrogant comments!!
	
	private ArrayList<Hotel> hotels=new ArrayList<Hotel>();
	private ArrayList<Reservation> reservations=new ArrayList<Reservation>();
	
	//Constructor not need to the solution
	-----------------
	public ReservationService(Hotel h, Currency c, int a, Room R) {
		hotel=h;
		curr=c;
		amount=a;
		room =R;
	}
	
	public ReservationService() {}
	--------------------
	
	//Use meaningfull variables res not accaptable
	//If is not part of interface method should be private
	//Useless method not need for the solution
	//You violate KISS and YAGNI
	public static Status getStatus(ReservationService res) {
		return res.status;
	}

	//Use meaningfull variables res not accaptable
	//If is not part of interface method should be private
	//Useless method not need for the solution
	//You violate KISS and YAGNI
	public static void setStatus(Status status, ReservationService res) {
		res.status = status;
	}

	//Use meaningfull variables res not accaptable
	//If is not part of interface method should be private
	//Useless method not need for the solution
	//You violate KISS and YAGNI
	public Date getFromDate() {
		Calendar fromCal = Calendar.getInstance();
		fromCal.setTime(fromDate);
		fromCal.add(Calendar.DATE, -5);
		return fromCal.getTime();
		//return fromDate;
	}

	//Use meaningfull variables res not accaptable
	//If is not part of interface method should be private
	//Useless method not need for the solution
	//You violate KISS and YAGNI
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	//Use meaningfull variables res not accaptable
	//If is not part of interface method should be private
	//Useless method not need for the solution
	//You violate KISS and YAGNI
	public Date getToDate(ReservationService res) {
		return res.toDate;
	}

	//Use meaningfull variables res not accaptable
	//If is not part of interface method should be private
	//Useless method not need for the solution
	//You violate KISS and YAGNI
	public void setToDate(Date toDate, ReservationService res) {
		res.toDate = toDate;
	}

	//Use meaningfull variables res not accaptable
	//If is not part of interface method should be private
	//Useless method not need for the solution
	//You violate KISS and YAGNI
	public static Currency getCurr(ReservationService res) {
		return res.curr;
	}

	//Use meaningfull variables res not accaptable
	//If is not part of interface method should be private
	//Useless method not need for the solution
	//You violate KISS and YAGNI
	public static void setCurr(Currency curr, ReservationService res) {
		res.curr = curr;
	}
	
	//Almost 
	public static void checkIn (ReservationService res) {
		res.status=Status.ACTIVE;
	}
	//Almost 
	public static void checkOut (ReservationService res) {
		res.status=Status.PROCESSED;
	}
	
	//Use meaningfull variables res not accaptable
	//If is not part of interface method should be private
	//Useless method not need for the solution
	//You violate KISS and YAGNI
	public String toString() {
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
		return "Your reservation has been set for " + sdt.format(fromDate) + " at the Hotel " + hotel.getName() + ", in room " + room.getNumber(room);
	}

	//Use meaningfull variables res not accaptable
	//If is not part of interface method should be private
	//Useless method not need for the solution
	//You violate KISS and YAGNI
	public Room getRoom(ReservationService res) {
		return res.room;
	}

	//Use meaningfull variables res not accaptable
	//If is not part of interface method should be private
	//Useless method not need for the solution
	//You violate KISS and YAGNI
	public void setRoom(Room room, ReservationService res) {
		res.room = room;
	}
}
//For All service getter and setter methods should not live in service all solution is WRONG!!
