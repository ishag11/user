package com.user.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Table(name="ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotBlank(message= "It should not be blank")
	//@Size(min=10, max=150)
	private String line1;
	
	//@Size(min=10, max=150)
	private String line2; 
	
	@NotBlank(message= "It should not be blank")
	@Size(min=3, max=30)
	private String city ; 
	
	@NotBlank(message= "It should not be blank")
	@Size(min=3, max=30)
	private String state; 
	
	@NotNull(message= "It should not be blank")
	@Size(min=6,max=6, message="It should contain only 6 digits")
	private String pincode;
	
	@OneToOne(mappedBy = "currentAddressId")
	private User userC;
	
	@OneToOne(mappedBy = "permanentAddressId")
	private User userP;
	
	
	public Address(int id, String line1, String line2, String city, String state, String pincode) {
		super();
		this.id = id;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public Address() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}	
	
}
