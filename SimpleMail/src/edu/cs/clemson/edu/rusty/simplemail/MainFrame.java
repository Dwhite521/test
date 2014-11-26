package edu.cs.clemson.edu.rusty.simplemail;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

/**
 * Created by rusty on 11/11/14.
 */
class MainFrame extends JFrame {
	JTable table;
	
    public MainFrame(ContactTableModel contactTableModel) {
        super("SimpleMail");
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
        
        // JFrame Properties
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        table = new JTable(contactTableModel);
        table.setGridColor(Color.LIGHT_GRAY);
        getContentPane().add(new JScrollPane(table));
		
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
			// Call the Configuration Dialog
		    JOptionPane.showMessageDialog((Component)event.getSource(),
		                                  "Your message goes here",
		                                  "Title goes here",
		                                  JOptionPane.INFORMATION_MESSAGE);
		  }
		});
		configMenu.add(configMenuItem);
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.add(new JMenuItem("About"));
		
		menuBar.add(fileMenu);
		menuBar.add(configMenu);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);
    }

}

