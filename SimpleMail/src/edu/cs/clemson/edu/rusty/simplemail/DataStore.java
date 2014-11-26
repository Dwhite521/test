package edu.cs.clemson.edu.rusty.simplemail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DataStore {
	private static DataStore instance = new DataStore();
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private Configuration configuration = new Configuration();
	private DataStore() {
		
	}
	
	public static DataStore getInstance() {
		return instance;
	}
	
	public void loadConfiguration() {
		
	}
	
	public void loadContacts() {
		
	}
	
	ArrayList <Contact> getContacts() {
		return contacts;
	}
	
	
	public void storeConfiguration() {
		
	}
	
	public void storeContacts() {
		
	}
}
