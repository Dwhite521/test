package edu.cs.clemson.edu.rusty.simplemail;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class SystemInformationDlg extends JDialog{
	JLabel infoLabel = new JLabel("<html><body> SimpleMail Client <br />By Rusty Davis and Devin White</body></html>", JLabel.CENTER);
	
	public SystemInformationDlg() {
		setSize(300, 150);
		add(infoLabel);
		pack();
	}
	
	public void setVisibe() {
		setVisible(true);
	}
	
	
}
