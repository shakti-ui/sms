package com.sms.io.dto;

import java.util.Date;

public class StudentDTO {
	private Integer sid;
	private String firstName;
	private String LastName;
	private String address;
	private String phoneNumber;
	private Date dob;
	private String email;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StudentDTO(Integer sid, String firstName, String lastName, String address, String phoneNumber, Date dob,
			String email) {
		super();
		this.sid = sid;
		this.firstName = firstName;
		LastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.email = email;
	}

	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StudentDTO [sid=" + sid + ", firstName=" + firstName + ", LastName=" + LastName + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", email=" + email + "]";
	}

}
