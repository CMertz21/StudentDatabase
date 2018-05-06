/*
 * File:BuildGUI.java
 * Author: Carrie Miles
 * Date: May 1 2018
 * Purpose: Create a GUI and provide functions for student database
 */
package database;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
	public static int userID = 0;
	private int grade;
	private int credit;
	public Student [] studentEntry = new Student [20];
	//hashMap
	public HashMap <Integer, Object> hmap = new HashMap<Integer,Object>();
	
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
		
		//JComboBox = insert
		if (selectionBox.getSelectedItem()=="Insert") {
			String userName = enterName.getText();
			String userMajor = enterMajor.getText();
			int putID = Integer.parseInt(enterTxtId.getText());
				//create a student
				Student user = new Student(userName, userMajor);
				//put student into array
				studentEntry[putID]=user;
				int hCount = (hmap.size());
				
				//put student into hmap
				if (hmap.containsKey(putID)==true) {
					JOptionPane.showMessageDialog(null, "Database already contains Student ID " + putID + ". Please use " +
					hCount + "as the next ID", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else if(hmap.containsKey(putID)==false) {
				hmap.put(putID, user);
				JOptionPane.showMessageDialog(null, "New Student added to the database.","Update Complete" ,  JOptionPane.INFORMATION_MESSAGE);
				System.out.println(putID);
				System.out.println(user.toString());
				}
			
				}
		//JComboBox = delete
		if (selectionBox.getSelectedItem() == "Delete") {
			int delID = Integer.parseInt(enterTxtId.getText());
			try {
				hmap.remove(delID);	
				//Notice that item was removed
				JOptionPane.showMessageDialog(null,"Student ID " + delID + " has been removed.");
	//Remove "//" below to check HMap contents after every Deletion		
				//JOptionPane.showMessageDialog(null, "HMap: " + hmap);
			}catch(NullPointerException e) {
				JOptionPane.showMessageDialog(null, "There is no student information for student ID "+delID);
			}
			
			
			
		}
		//JComboBox = Find
		if (selectionBox.getSelectedItem()=="Find") {
			int findID = Integer.parseInt(enterTxtId.getText());
			JOptionPane.showMessageDialog(null, "Entry Found: \n" + hmap.get(findID));
		}
		
		//update entry
		if (selectionBox.getSelectedItem()== "Update") {
			String[] selGrade = new String [] {"A", "B", "C", "D", "F"} ; //Grade Menu Options
			String [] selCredit = new String [] {"3","4","6"}; //Credit Hour menu Options
			Student temp = new Student(); 
			int upID = Integer.parseInt(enterTxtId.getText());  
			JComboBox<String> box = new JComboBox<String>(selGrade);
			JComboBox<String> numBox = new JComboBox<String>(selCredit);
			temp = studentEntry[upID]; //placeholder object to hold hash map data while updating entry
			
			JOptionPane.showMessageDialog(null, box, "Choose Grade", JOptionPane.QUESTION_MESSAGE);
			if (box.getSelectedItem()=="A") {
				grade = 4;
			}
			if (box.getSelectedItem()=="B") {
				grade =3;
			}
			if (box.getSelectedItem()=="C") {
				grade=2;
			}
			if (box.getSelectedItem()=="D") {
				grade=1;
			}
			if (box.getSelectedItem()=="F") {
				grade=0;
			}
			
			JOptionPane.showMessageDialog(null, numBox, "Choose Credits", JOptionPane.QUESTION_MESSAGE); 
			if (numBox.getSelectedItem()=="3") {
				credit = 3;
			}
			if (numBox.getSelectedItem()=="4") {
				credit =4;
			}
			if (numBox.getSelectedItem()=="6") {
				credit = 6;
			}
			try{
				System.out.println("update values: " + grade +" "+credit);
				//GPA and total Q points update
				temp.courseCompleted(grade, credit);
				hmap.put(upID, temp);
				JOptionPane.showMessageDialog(null, "Student ID " + upID + " has been updated.", "Update Success", JOptionPane.PLAIN_MESSAGE);
			}catch(NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Error: Null Pointer");
			}
		}
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
