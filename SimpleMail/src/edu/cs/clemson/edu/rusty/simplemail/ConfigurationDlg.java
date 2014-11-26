package edu.cs.clemson.edu.rusty.simplemail;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigurationDlg extends JDialog {
	private JLabel emailLabel = new JLabel("email");
	private JLabel smptAddressLAbel = new JLabel("smtp address");
	private JLabel nameLabel = new JLabel("name");
	
	private JTextField emailAddressField;
	private JTextField smtpAddressField;
	private JTextField nameField;
	private JPanel buttons;
	
    public ConfigurationDlg() {
    	buttons = new JPanel();
    	buttons.setLayout(new FlowLayout());
    	JButton saveButton = new JButton("Save");
    	JButton cancelButton = new JButton("Cancel");
    	// Validate the data and update the DataStore
    	
    	saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
               String newEmail = emailAddressField.getText();
               // Validate email
               String newName = nameField.getText();
               String newSmtpAddress = smtpAddressField.getText();      
            }
         }); 
    	
    	cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
            	// Closes and destroys the window object
            	dispose();
            }
         }); 
    }
    

}
