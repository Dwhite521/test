package edu.cs.clemson.edu.rusty.simplemail;

public class MainDriver {
	public static void main(String args[]) {
		
		ContactTableModel contactTableModel = new ContactTableModel();
		contactTableModel.addContact(new Contact("Bluth", "Gob", "magicman@hotmail.com", "red"));
		MainFrame mf = new MainFrame(contactTableModel);
		mf.pack();
		mf.setVisible(true);
	}
}
