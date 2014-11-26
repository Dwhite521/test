package edu.cs.clemson.edu.rusty.simplemail;

import java.io.Serializable;

public class Contact implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String postalAddress;
	private String phoneNumber;
	private String emailAddress;
	
	
	public Contact(String name, String postalAddress, String phoneNumber, String emailAddress) {
		this.name = name;
		this.postalAddress = postalAddress;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
