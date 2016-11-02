package com.elektrobit.eso_MIB2H_Speech.Graphics;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.border.EtchedBorder;


@SuppressWarnings("serial")
public class Start extends JFrame implements ActionListener {
	
	
	
	public JPanel selectPanel ; // Top Panel for the selection
	public JPanel welcomePanel; // Panel just to show the welcome message
	
	public JMenuBar menuBar;
	public JMenu fileMenu;
	public JMenu docMenu;
	public JMenu toolMenu;
	public JMenu helpMenu;
	public JMenuItem exitItem;
	public JMenuItem rNotes;
	public JMenuItem approvals;
	public JMenuItem MIB2Plus;
	public JMenuItem MIB2;
	public JMenuItem MIB;
	
	
	public JSplitPane splitPanel;
	
	public JPanel workingPanel;
	
	public JPanel logPanel;
	public JTextArea logArea;
	
	//Temp
	public JButton btnTmp;
	public static SwingWorker<String, String> worker;
	
	public void createAndShowGUI(){
		
		this.setTitle("Elektrobit : Integration Tools");
		this.getContentPane().setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(800, 600));
		
		/**
		 * Create add Menu bar
		 */
		CreateMenuBar();
		
		/**
		 * Now add the Select Plane
		 */
		this.getContentPane().add(getSelectPanel(), BorderLayout.NORTH);
		
		/**
		 * Add the Split Panel
		 */
		this.getContentPane().add(getSplitPanel(), BorderLayout.CENTER);
		
		/**
		 * Add the Welcome Panel at the beginning
		 */
		//this.getContentPane().add(getWelcomePanel(),BorderLayout.CENTER);
		
		/**
		 * Add the LogPanel at the Bottom
		 */
		//this.getContentPane().add(getLogPanel(), BorderLayout.SOUTH);
		
		/**
		 * Now Make it Visible
		 */
		this.setVisible(true);
	}
	
	/*******************************************************************************************************************************************************
	 *  Display Panel Block Begins
	 * 
	 *******************************************************************************************************************************************************/
	/**
	 * Select Panel
	 */
	public JPanel getSelectPanel(){
		selectPanel = new JPanel();
		selectPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		selectPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10 , 10));
		
		JLabel tmp = new JLabel("This is a temp");
		selectPanel.add(tmp);
		btnTmp = new JButton("Temp Button");
		btnTmp.addActionListener(this);
		selectPanel.add(btnTmp);
				
		return selectPanel;
	}
	
	/**
	 * SplitPanel to Split the Logviewer and the Working Panel vertically
	 */
	public JSplitPane getSplitPanel(){
		splitPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);//, getWelcomePanel() , getLogPanel());
		splitPanel.setTopComponent(getWelcomePanel());
		splitPanel.setBottomComponent(null);
		splitPanel.setOneTouchExpandable(true);
		splitPanel.setContinuousLayout(true);
		return splitPanel;
	}
	
	
	/**
	 * Welcome Default Panel
	 */
	public JPanel getWelcomePanel(){
		welcomePanel = new JPanel();
		welcomePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null , null));
		//welcomePanel.setBounds(8, 64 , 774 , 246);

		JLabel welcomeLabel = new JLabel();
		welcomeLabel.setText("<html><font size='5' color='#BD421C'>Welcome to the Elektrobit eso_MIB2High_Speech Integration Tools.</font><br><br>In order to "
				+ "work further please use the Menubar to select the desired function OR "
				+ "Please us the Radio button above to select an option.<br><br>"
				+ "For further help please go to help Menu.</html>");
		
		welcomePanel.add(welcomeLabel);
		return welcomePanel;
	}
	
	
	/**
	 * LogPanel 
	 */
	
	public JPanel getLogPanel(){
		logPanel = new JPanel();
		logPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null , null));
		logPanel.setLayout((new BoxLayout(logPanel, BoxLayout.Y_AXIS)));
		logArea = new JTextArea();
		
		logArea.setBackground(Color.WHITE);
		logArea.setEditable(false);
		JScrollPane sp =  new JScrollPane(logArea);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			
		logPanel.add(logArea);
		return logPanel;
	}
	
	
	
	/*******************************************************************************************************************************************************
	 *  Display Panel Block Ends
	 * 
	 *******************************************************************************************************************************************************/
	
	/*******************************************************************************************************************************************************
	 *  Menu Panel Block Begins
	 * 
	 *******************************************************************************************************************************************************/
	public void CreateMenuBar(){
		menuBar = new JMenuBar();
		// File menu
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		fileMenu.addActionListener(this);
		
		// Exit Menu Item
		exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.addActionListener(this);
		// Add all the menu item in File Menu
		fileMenu.add(exitItem);
		
		// Document Menu
		docMenu = new JMenu("Document");
		docMenu.setMnemonic(KeyEvent.VK_D);
		
		// Prepare DocMenu Items
		// prepare menu item in doc Menu
		rNotes = new JMenuItem("Release Notes");
		rNotes.setMnemonic(KeyEvent.VK_R);
		rNotes.addActionListener(this);
		
		approvals = new JMenuItem("Approvals");
		approvals.setMnemonic(KeyEvent.VK_A);
		approvals.addActionListener(this);
	
		//Add All Menu Item in 
		docMenu.add(rNotes);
		docMenu.add(approvals);
				
		// Add all the Menus in Menubar
		menuBar.add(fileMenu);
		menuBar.add(docMenu);
		setJMenuBar(menuBar);
	}
	
	/*******************************************************************************************************************************************************
	 *  Menu Panel Block Ends
	 * 
	 *******************************************************************************************************************************************************/
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// Let us catch the action event source and perform the action
		if(event.getSource() == exitItem){
			System.out.println("Exit Menu has been Pressed");
			System.exit(0);
		} else if (event.getSource() == rNotes){
			System.out.println("Release Note builder");
			this.splitPanel.setTopComponent(getWelcomePanel());
			this.splitPanel.setBottomComponent(getLogPanel());
			this.refreshWindow();
			
		} else if (event.getSource() == approvals){
			System.out.println("Approval builder");
			//this.getContentPane().remove(splitPanel);
			//this.getContentPane().add(welcomePanel);
			this.splitPanel.setTopComponent(getWelcomePanel());
			this.splitPanel.setBottomComponent(getLogPanel());
			this.refreshWindow();
			
		} else if (event.getSource() == btnTmp) {
			System.out.println("Button called");
			this.setLog("Running");
			
		}
		
	}
	
	/**
	 * Helper Method refresh Frame
	 */
	public void refreshWindow(){
		this.getContentPane().repaint();
		this.getContentPane().revalidate();
	}
	
	/**
	 * Sample Method Set Log
	 */
	public void setLog(String message){
		logArea.append(new Date() + " " + message + "\n");
		logArea.setCaretPosition(logArea.getDocument().getLength());
	}
	
	public JTextArea getTextAreaClients(){
		return this.logArea;
	}

	/**
	 * Main Method Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Start start = new Start();
				start.createAndShowGUI();
				System.out.println(this.getClass().getName());
			}
		});
	}

}
