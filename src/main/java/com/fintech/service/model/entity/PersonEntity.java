package com.fintech.service.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
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
       name = "person")
public class PersonEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    @Column(
            name = "last_name")
    public String lastName;
    @Column(
            name = "gender")
    public String gender;
    
    public Boolean active;
    
    @JoinColumn(
            name = "creditcard_id",
            referencedColumnName = "id")
    @OneToOne(
            fetch = FetchType.LAZY)
    private CreditCardEntity creditCardId;
    
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
	public CreditCardEntity getCreditCardId() {
		return creditCardId;
	}
	public void setCreditCardId(CreditCardEntity creditCardId) {
		this.creditCardId = creditCardId;
	}
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
}
