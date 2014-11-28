package edu.cs.clemson.edu.rusty.simplemail;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;

/**
 * Created by rusty on 11/17/14.
 */
public class ContactTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
    static String[] columns = {"Name", "Email Address", "Phone Number", "Postal Address"};
    
    @Override
    public int getRowCount() {
        return table.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return table.get(rowIndex).get(columnIndex);
    }

    public void addContact(Contact contact) {
        int row = getRowCount();
        table.add(new ArrayList<String>());
        table.get(row).add(contact.getName());
        table.get(row).add(contact.getEmailAddress());
        table.get(row).add(contact.getPhoneNumber());
        table.get(row).add(contact.getPostalAddress());
        fireTableRowsInserted(row, row);
    }

    public void removeContact(int row) {
        table.remove(row);
    }
    // Provides Column Names
    @Override
    public String getColumnName(int index) {
        return columns[index];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }


}
