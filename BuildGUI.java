package database;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BuildGUI implements ActionListener {
	public static JTextArea writeTxtId = new JTextArea ("ID: ");
	public static JTextField enterTxtId = new JTextField(10);
	public static JTextArea writeName = new JTextArea("Name: ");
	public static JTextField enterName = new JTextField(10);
	public static JTextArea writeMajor	= new JTextArea("Major: ");
	public static JTextField enterMajor = new JTextField(10);
	public static JTextArea writeSelect = new JTextArea("Choose Selection: ");
	public static String [] selectionMenu = new String [] {"Insert", "Delete", "Find", "Update"};
	public static JComboBox<String> selectionBox = new JComboBox <String>(selectionMenu);
	public static JButton process = new JButton("Process Request");
	public static int useEnt;
	
	
	public void addComponentsToPane(Container pane) {
		
		pane.setLayout(new GridBagLayout());
		pane.setBackground(Color.WHITE);
		
		//Text for ID:
		GridBagConstraints txtId = new GridBagConstraints();
		txtId.weightx = 1.0;
		txtId.gridx = 0;
		txtId.gridy = 0;
		pane.add(writeTxtId, txtId);
		
		GridBagConstraints wrId = new GridBagConstraints();
		wrId.weightx=1.0;
		wrId.gridx = 2;
		wrId.gridwidth=2;
		wrId.gridy=0;
		pane.add(enterTxtId, wrId);
		
		//Text for Name
		GridBagConstraints txtName = new GridBagConstraints();
		txtName.weightx = 1.0;
		txtName.gridx=0;
		txtName.gridy = 1;
		pane.add(writeName, txtName);
		
		GridBagConstraints wrName = new GridBagConstraints();
		wrName.weightx = 1.0;
		wrName.gridx = 2;
		wrName.gridwidth =2;
		wrName.gridy=1;
		pane.add(enterName, wrName);
		
		//Text for Major
		GridBagConstraints txtMajor = new GridBagConstraints();
		txtMajor.weightx = 1.0;
		txtMajor.gridx = 0;
		txtMajor.gridy=2;
		pane.add(writeMajor, txtMajor);
		
		GridBagConstraints wrMajor = new GridBagConstraints();
		wrMajor.weightx = 1.0;
		wrMajor.gridx = 2;
		wrMajor.gridwidth=2;
		wrMajor.gridy = 2;
		pane.add(enterMajor, wrMajor);
		
		//Text for Write Selection
		GridBagConstraints txtSelect = new GridBagConstraints();
		txtSelect.weightx = 1.0;
		txtSelect.gridx = 0;
		txtSelect.gridy = 3;
		pane.add(writeSelect, txtSelect);
		
		//Combo button for selection
		GridBagConstraints selectBox = new GridBagConstraints();
		selectBox.weightx = 1.0;
		selectBox.gridx=2;
		selectBox.gridy=3;
		pane.add(selectionBox, selectBox);
		
		//Button for Processing
		GridBagConstraints proButton = new GridBagConstraints();
		proButton.weightx = 1.0;
		proButton.weighty= 1.0;
		proButton.gridx=2;
		proButton.gridwidth = 2;
		proButton.gridy = 4;
		process.addActionListener(this);
		pane.add(process, proButton);
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		//ensure that the ID is an integer 
		String idText = enterTxtId.getText();
			try {
				useEnt = Integer.parseInt(idText);
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Please enter only integers");
			}catch(NullPointerException e) {
				JOptionPane.showMessageDialog(null,  "Error: Could not locate entry. Please try again.");
			}
		//ensure that the entry is in database
			//TODO search file for entries
		
		//if JComboBox = delete
		
		
	}
	
	private void createAndShowGUI() {
		//Create and setup the window
		JFrame frame = new JFrame("Project 4");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		addComponentsToPane(frame.getContentPane());
		
		//Display the Window
		frame.pack();
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BuildGUI gui = new BuildGUI();
				gui.createAndShowGUI();
			}
		});
	}//end main

}
