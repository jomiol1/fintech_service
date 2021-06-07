package com.fintech.service.rest.dto;

import com.fintech.service.rest.model.CreditCard;

public class PersonRequest {
	
    private String name;
    private String lastName;
    private String gender;
    private CreditCard creditCard;
    
    public PersonRequest() {}
    
	public PersonRequest(String name, String lastName, String gender, CreditCard creditCard) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.creditCard = creditCard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
}
