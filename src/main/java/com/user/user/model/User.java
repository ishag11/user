package com.user.user.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="USER")
public class User {
	
	@Id 
	private String rollno; 
	
	@NotEmpty(message= "This field should not be empty")
	@Size(min=3, max=15, message= "length should be between 3 and 15")
	private String firstName;
	
	@NotBlank(message= "This field should not be empty")
	@Size(min=3, max=15, message= "length should be between 3 and 15")
	private String lastName;
	
	
	@Size(min=3, max=15, message= "length should be between 3 and 15")
	private String fatherName;
	
	//@Enumerated(EnumType.STRING)
	private String gender;
	
	@NotNull(message= "This field should not be empty")
	@Email
	@Size(max = 30)
	@Column(unique = true)
	private String emailID; 
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
	@NotNull(message = "Please provide a date.")
	//@Temporal(TemporalType.DATE)
	private Date dob;
	
	@NotNull(message= "This field should not be empty")
	@Size(min=10,max=10, message="It should contain only 10 digits")
	private String phonenumber;
	
	@NotNull(message= "This field should not be empty")
	@Size(min=10,max=10, message="It should contain only 10 digits")
	private String emergenceContact;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="currentAddressId", referencedColumnName="Id")
//	@NotBlank(message= "This field should not be empty")
	private Address currentAddressId; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="permanentAddressId", referencedColumnName="Id")
	private Address permanentAddressId;
	

	@NotBlank(message = "Please provide a date.")
	//@Temporal(TemporalType.DATE)
	private String yearOfJoining;
	
	@NotBlank(message= "This field should not be empty")
	@Size(min=2, max=20, message= "length should be between 2 and 20")
	private String dept;
	
	@NotBlank(message= "This field should not be empty")
	@Size(min=2, max=10, message= "length should be between 2 and 10")
	private String batch ;
	
	private LocalDate createdDate;
	
	@NotBlank
	private String createdBy;
	
	
	private LocalDate lastModifiedDate;
	
	@NotBlank
	private String lastModifiedBy;
	
	private boolean isDeleted = Boolean.FALSE;
	

	public User(String rollno,
			@NotEmpty(message = "This field should not be empty") @Size(min = 3, max = 15, message = "length should be between 3 and 15") String firstName,
			@NotBlank(message = "This field should not be empty") @Size(min = 3, max = 15, message = "length should be between 3 and 15") String lastName,
			@Size(min = 3, max = 15, message = "length should be between 3 and 15") String fatherName, String gender,
			@NotNull(message = "This field should not be empty") @Email @Size(max = 30) String emailID,
			@NotNull(message = "Please provide a date.") Date dob,
			@NotNull(message = "This field should not be empty") @Size(min = 10, max = 10, message = "It should contain only 10 digits") String phonenumber,
			@NotNull(message = "This field should not be empty") @Size(min = 10, max = 10, message = "It should contain only 10 digits") String emergenceContact,
			Address currentAddressId, Address permanentAddressId,
			@NotBlank(message = "Please provide a date.") String yearOfJoining,
			@NotBlank(message = "This field should not be empty") @Size(min = 2, max = 20, message = "length should be between 2 and 20") String dept,
			@NotBlank(message = "This field should not be empty") @Size(min = 2, max = 10, message = "length should be between 2 and 10") String batch,
			LocalDate createdDate, @NotBlank String createdBy, LocalDate lastModifiedDate,
			@NotBlank String lastModifiedBy, boolean isDeleted) {
		super();
		this.rollno = rollno;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.gender = gender;
		this.emailID = emailID;
		this.dob = dob;
		this.phonenumber = phonenumber;
		this.emergenceContact = emergenceContact;
		this.currentAddressId = currentAddressId;
		this.permanentAddressId = permanentAddressId;
		this.yearOfJoining = yearOfJoining;
		this.dept = dept;
		this.batch = batch;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedBy = lastModifiedBy;
		this.isDeleted = isDeleted;
	}


	public User() {
		
	}


	public String getRollno() {
		return rollno;
	}


	public void setRollno(String rollno) {
		this.rollno = rollno;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmailID() {
		return emailID;
	}


	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getEmergenceContact() {
		return emergenceContact;
	}


	public void setEmergenceContact(String emergenceContact) {
		this.emergenceContact = emergenceContact;
	}


	public Address getCurrentAddressId() {
		return currentAddressId;
	}


	public void setCurrentAddressId(Address currentAddressId) {
		this.currentAddressId = currentAddressId;
	}


	public Address getPermanentAddressId() {
		return permanentAddressId;
	}


	public void setPermanentAddressId(Address permanentAddressId) {
		this.permanentAddressId = permanentAddressId;
	}


	public String getYearOfJoining() {
		return yearOfJoining;
	}


	public void setYearOfJoining(String yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getBatch() {
		return batch;
	}


	public void setBatch(String batch) {
		this.batch = batch;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}


	public LocalDate getLastModifiedDate() {
		return lastModifiedDate;
	}


	public void setLastModifiedDate(LocalDate lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getlastModifiedBy() {
		return lastModifiedBy;
	}


	public void setlastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}


	public boolean isDeleted() {
		return isDeleted;
	}


	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	@Override
	public String toString() {
		return "User [rollno=" + rollno + ", firstName=" + firstName + ", lastName=" + lastName + ", fatherName="
				+ fatherName + ", gender=" + gender + ", emailID=" + emailID + ", dob=" + dob + ", phonenumber="
				+ phonenumber + ", emergenceContact=" + emergenceContact + ", currentAddressId=" + currentAddressId
				+ ", permanentAddressId=" + permanentAddressId + ", yearOfJoining=" + yearOfJoining + ", dept=" + dept
				+ ", batch=" + batch + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", lastModifiedDate=" + lastModifiedDate + ", lastModifiedBy=" + lastModifiedBy + ", isDeleted="
				+ isDeleted + "]";
	}

}
