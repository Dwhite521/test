package edu.cs.clemson.edu.rusty.simplemail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataStore {
	private static DataStore instance = new DataStore();
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private Configuration config = new Configuration();
	
	// Private constructor to defeat all instantiation attemtpts
	private DataStore() {

	}

	public static DataStore getInstance() {
		return instance;
	}

	public void loadConfiguration() {
		File f = new File("config.bin");
		// Load the contacts file from the bin
		if (f.exists()) {
			System.out.println("Found data file!\nReading...");
			try {
				FileInputStream fileInput = new FileInputStream(f);
				ObjectInputStream objectInput = new ObjectInputStream(fileInput);
				config = (Configuration)objectInput.readObject();
				objectInput.close();
				fileInput.close();
				System.out.println("Success!");
			} catch (Exception e) {
				System.out.println("Failed.");
			}
		}
	}

	public void storeConfiguration() {
		File f = new File("config.bin");
        try {
            FileOutputStream fileOutput = new FileOutputStream(f);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(config);
            objectOutput.close();
            fileOutput.close();
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println("Failed.");
        }
	}

	public Configuration getConfiguration() {
		return config;
	}
	
	// I have to supress unchecked cast warning for the code on line 70 to not bring up a warning on Eclipse
	// As far as I can tell, there is no alternative
	@SuppressWarnings("unchecked")
	public void loadContacts() {
		File f = new File("contacts.bin");
		// Load the contacts file from the bin
		if (f.exists()) {
			System.out.println("Found data file!\nReading...");
			try {
				FileInputStream fileInput = new FileInputStream(f);
				ObjectInputStream objectInput = new ObjectInputStream(fileInput);
				ArrayList<Contact> readObject = (ArrayList<Contact>) objectInput.readObject();
				contacts = readObject;
				objectInput.close();
				fileInput.close();
				System.out.println("Success!");
			} catch (Exception e) {
				System.out.println("Failed.");
			}
		}
	}

	public void storeContacts() {
		File f = new File("contacts.bin");
         try {
             FileOutputStream fileOutput = new FileOutputStream(f);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
             objectOutput.writeObject(contacts);
             objectOutput.close();
             fileOutput.close();
             System.out.println("Success!");
         } catch (Exception e) {
             System.out.println("Failed.");
         }
	}
	
	ArrayList <Contact> getContacts() {
		return contacts;
	}
}
