package edu.cs.clemson.edu.rusty.simplemail;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by rusty on 11/17/14.
 */
public class ContactTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
    static String[] column = {"Last Name", "First Name", "Email Address", "Postal Address"};
    
    @Override
    public int getRowCount() {
        return table.size();
    }

    @Override
    public int getColumnCount() {
        return table.get(0).size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return table.get(rowIndex).get(columnIndex);
    }

    public void addContact(Contact contact) {
        int row = getRowCount();
        table.add(new ArrayList<String>());
        table.get(row).add(contact.getEmailAddress());
        table.get(row).add(contact.getName());
        table.get(row).add(contact.getPhoneNumber());
        table.get(row).add(contact.getPostalAddress());
    }

    public void removeContact(int row) {
        table.remove(row);
    }
    // Provides Column Names
    @Override
    public String getColumnName(int index) {
        return column[index];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }



}
