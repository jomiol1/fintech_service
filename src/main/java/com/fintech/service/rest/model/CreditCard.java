package com.fintech.service.rest.model;

public class CreditCard {
	
	private String number;
	private String cvv;
	private String year;
	private String month;
	
	public CreditCard() {}
	
	public CreditCard(String number, String cvv, String year, String month) {
		super();
		this.number = number;
		this.cvv = cvv;
		this.year = year;
		this.month = month;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	

}
