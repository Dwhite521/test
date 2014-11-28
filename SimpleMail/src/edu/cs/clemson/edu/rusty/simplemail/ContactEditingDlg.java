package edu.cs.clemson.edu.rusty.simplemail;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ContactEditingDlg extends JDialog {
	// We're going to want to use the strategy pattern here. We'll either want to edit a contact or create a new contact
	private JPanel textPanel;
	private JPanel buttonPanel;
	private ContactTableModel model;
	private ArrayList<JTextField> fields = new ArrayList<JTextField>(); 
	
	public ContactEditingDlg(ContactTableModel model) {
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        // We need to be able to access the model for the table so we can make changes
        this.model = model;
		textPanel = setupText();
    	buttonPanel = setupButtons();
    	
		getContentPane().add(textPanel);
		getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
	}

	private JPanel setupText() {
		String[] labels = {"Name: ", "Phone: ", "Email: ", "Address: "};
        int numPairs = labels.length;

        JPanel textPanel = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            textPanel.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            textPanel.add(textField);
           // Save the references to the textfield so we can access them later
            fields.add(textField);
        }

        //Lay out the panel
        // Uses a class provided by Oracle SpringUtilities.java
        SpringUtilities.makeCompactGrid(textPanel,
                                        numPairs, 2, //rows, cols
                                        9, 9,        //initX, initY
                                        9, 9);       //xPad, yPad
		return textPanel;
	}

	private JPanel setupButtons() {
		JPanel buttonPanel = new JPanel();
    	JButton saveButton = new JButton("Save");
    	saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
            	 String name = fields.get(0).getText();
            	 String phone = fields.get(1).getText();
            	 String email  = fields.get(2).getText();
            	 String address = fields.get(3).getText();
            	 model.addContact(new Contact(name, phone, email, address));
            	 dispose();
            }
         }); 
    	JButton cancelButton = new JButton("Cancel");
    	buttonPanel.add(saveButton);
    	buttonPanel.add(cancelButton);
    	buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		return buttonPanel;
	}

	private void setupPanel(JPanel textPanel) {
		textPanel.setLayout(new BorderLayout());
    	
		JLabel nameLabel = new JLabel("Name");
		JTextField nameField = new JTextField("", 1);
		JLabel emailAddressLabel = new JLabel("Email Address: ");
		JTextField emailField = new JTextField("", 1);
		
		JLabel phoneNumberLabel = new JLabel("Phone Number");
		JTextField phoneField = new JTextField("", 1);

		
		textPanel.add(nameLabel);
		textPanel.add(nameField);
		
		textPanel.add(emailAddressLabel);
		textPanel.add(emailField);
		
		textPanel.add(phoneNumberLabel);
		textPanel.add(phoneField);

	}
}
