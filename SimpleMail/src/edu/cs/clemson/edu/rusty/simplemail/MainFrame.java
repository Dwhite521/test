package edu.cs.clemson.edu.rusty.simplemail;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

/**
 * Created by rusty on 11/11/14.
 */
class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	ContactTableModel model;
	
    public MainFrame() {
        super("SimpleMail");
        macCompatible();
        // JFrame Properties
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        addTable();
        addButtons();
		addMenu();
    }

	private void addMenu() {
		// Menu Bar
        JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		// Exit action Listener
		exitItem.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent event)
		  {
			System.exit(0);
		  }
		});
		fileMenu.add(exitItem);
		
		JMenu configMenu = new JMenu("Configuration");
		JMenuItem configMenuItem = new JMenuItem("Configure");
		// Config action Listener
		configMenuItem.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent event)
		  {
			  ConfigurationDlg dlg = new ConfigurationDlg();
			  dlg.setVisible(true);
		  }
		});
		configMenu.add(configMenuItem);
		
		JMenu helpMenu = new JMenu("Help");
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent event)
		  {
			  SystemInformationDlg dlg = new SystemInformationDlg();
			  dlg.setVisibe();
		  }
		});
		helpMenu.add(aboutItem);
		
		menuBar.add(fileMenu);
		menuBar.add(configMenu);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);
	}

	private void addTable() {
		model = new ContactTableModel();
        table = new JTable(model);
        table.setGridColor(Color.LIGHT_GRAY);
        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	private void addButtons() {
		JPanel buttonPanel = new JPanel(); 
		// Helps correctly align the buttons ot the left
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent event)
		  {
			ContactEditingDlg dlg = new ContactEditingDlg(model);
			dlg.setVisible(true);
		  }
		});

		JButton editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent event)
		  {
			ContactEditingDlg dlg = new ContactEditingDlg(model);
			dlg.setVisible(true);
		  }
		});
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent event)
		  {
			  if (table.getSelectedRow() != -1) {
				  // Shows a simple yes or no prompt
				  int result = JOptionPane.showConfirmDialog(
				            null,
				            "Are you sure you want to delete the contact information for " + table.getValueAt(table.getSelectedRow(), 0) + ".",
				            "Contact Deletin Confirmation",
				            JOptionPane.YES_NO_OPTION);
				  if (result == JOptionPane.YES_OPTION) {
					  model.removeContact(table.getSelectedRow());
					  model.fireTableRowsDeleted(table.getSelectedRow(), table.getSelectedRow());
				  }
			  }
		  }
		});
		
		buttonPanel.add(addButton);
		buttonPanel.add(editButton);
		buttonPanel.add(deleteButton);
		getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
	}

	private void macCompatible() {
        String lcOSName = System.getProperty("os.name").toLowerCase();
        boolean IS_MAC = lcOSName.startsWith("mac os x");
    	// Displays the menuBar on the taskbar if on mac os x
        if (IS_MAC) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");

            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "SimpleMail");
        }

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

