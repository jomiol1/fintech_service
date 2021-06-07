package com.fintech.service.rest.dto;

import com.fintech.service.rest.model.CreditCard;

public class PersonResponse {
	
    private Long id;
	private String name;
    private String lastName;
    private String gender;
    private CreditCard creditCard;
    
	public PersonResponse(Long id, String name, String lastName, String gender, CreditCard creditCard) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.creditCard = creditCard;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
