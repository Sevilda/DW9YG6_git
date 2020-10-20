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
	
	private Status status; //booked, active, processed - don't see the point in using booleans when we can use enums for the same purpose. 
	private Hotel hotel;
	private Room room;
	private Date fromDate = new Date();
	private Date toDate = fromDate;
	private Currency curr;
	private int amount;
	private Reservation res;
	private ArrayList<Hotel> hotels=new ArrayList<Hotel>();
	private ArrayList<Reservation> reservations=new ArrayList<Reservation>();
	
	public ReservationService(Hotel h, Currency c, int a, Room R) {
		hotel=h;
		curr=c;
		amount=a;
		room =R;
	}
	
	public ReservationService() {}
	
	public static Status getStatus(ReservationService res) {
		return res.status;
	}

	public static void setStatus(Status status, ReservationService res) {
		res.status = status;
	}

	public Date getFromDate() {
		Calendar fromCal = Calendar.getInstance();
		fromCal.setTime(fromDate);
		fromCal.add(Calendar.DATE, -5);
		return fromCal.getTime();
		//return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate(ReservationService res) {
		return res.toDate;
	}

	public void setToDate(Date toDate, ReservationService res) {
		res.toDate = toDate;
	}

	public static Currency getCurr(ReservationService res) {
		return res.curr;
	}

	public static void setCurr(Currency curr, ReservationService res) {
		res.curr = curr;
	}
	
	
	public static void checkIn (ReservationService res) {
		res.status=Status.ACTIVE;
	}
	
	public static void checkOut (ReservationService res) {
		res.status=Status.PROCESSED;
	}
	
	public String toString() {
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
		return "Your reservation has been set for " + sdt.format(fromDate) + " at the Hotel " + hotel.getName() + ", in room " + room.getNumber(room);
	}

	public Room getRoom(ReservationService res) {
		return res.room;
	}

	public void setRoom(Room room, ReservationService res) {
		res.room = room;
	}
}
