package com.meiit.webalk.reservation.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BookingPerson extends User {

	private String name;
	private int accountNumber;
	private BigDecimal balance;
	private Date birth;
	private Currency curr;


	public BookingPerson(String n, BigDecimal b, Currency c) {
		setName(n);
		setBalance(b);
		setCurrency(c);
	}
	
	public String toString() {
		return ("nev: " + name + " email " + email + "curr: " + curr);
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	};
	
	public Currency getCurrency() {
		return curr;
	}

	public void setCurrency(Currency curr) {
		this.curr = curr;
	};
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
