package com.meiit.webalk.reservation.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
	
	private boolean active;
	private boolean processed;
	private String name;
	private Room room;
	private Date fromDate = new Date();
	private Date toDate = fromDate;
	private Currency curr;
	private BigDecimal amount;
	
	public Reservation(String n,  Room R) {
		setName(n);
		setRoom(R);
	}
	

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String toString() {
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
		return "Your reservation has been set for " + sdt.format(fromDate) + ", in room " + room.getNumber();
	}


	public void setActive(boolean b) {
		this.active=b;
		
	}


	public void setProcessed(boolean b) {
		this.processed=b;
	}

}
