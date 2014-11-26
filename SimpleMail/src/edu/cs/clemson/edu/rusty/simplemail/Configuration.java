package edu.cs.clemson.edu.rusty.simplemail;

import java.io.Serializable;

public class Configuration implements Serializable {
	private static final long serialVersionUID = 1L;
	private String emailAddress;
	private String smtpAddress;
	private String name;

	public Configuration(String emailAddress, String smtpAddress, String name) {
		this.emailAddress = emailAddress;
		this.smtpAddress = smtpAddress;
		this.name = name;
	}

	public Configuration() {

	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getSmtpAddress() {
		return smtpAddress;
	}

	public void setSmtpAddress(String smtpAddress) {
		this.smtpAddress = smtpAddress;
	}
	
	
}
