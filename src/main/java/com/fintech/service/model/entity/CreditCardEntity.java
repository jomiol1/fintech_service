package com.fintech.service.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
*
* @author jose m oliveros
*/
@Entity
@Table(
       name = "creditcard")
public class CreditCardEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;
    public String number;
    public String cvv;
    public String month;
    public String year;
    
    @JoinColumn(
            name = "person_id",
            referencedColumnName = "id")
    @OneToOne(
            fetch = FetchType.LAZY)
    private PersonEntity personId;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public PersonEntity getPersonId() {
		return personId;
	}
	public void setPersonId(PersonEntity personId) {
		this.personId = personId;
	}
	
}
