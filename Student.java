/*
 * File:Student.java
 * Author: Carrie Miles
 * Date: May 1 2018
 * Purpose: Create students and handle student data
 */
package database;

public class Student {

	private String name;
	private String major;
	private double GPA=4.0;
	private double totalCredits;
	private double totalQPoints;
	private double totalGrades;
	
//constructor	
	public Student() {
		this.name = " ";
		this.major= " ";
		this.GPA=4.0;
		this.totalCredits=0;
		this.totalQPoints = 0;
	}
//constructor
	public Student (String name, String major) {
		this.name = name;
		this.major = major;
		this.GPA = 4.0;
		this.totalCredits = 0;
		this.totalQPoints = 0;
		
	}

	//Calculates the GPA and total Q points whenever an entry is updated
	public void courseCompleted(double grade, double credit) {
		this.totalCredits = this.totalCredits+credit;
		this.totalGrades = this.totalGrades+grade;
		setTotalQPoints(grade, credit);
		setGPA(this.totalQPoints, this.totalCredits);
		
	}
	
	//get GPA
	public double getGPA() {
		return GPA;
	}
		
	//helps compute the total  Q Points
	public void setTotalQPoints(double grade, double credit) {
		this.totalQPoints=totalQPoints+(grade*credit);
	}
	//helps compute the total GPA	
	public void setGPA( double totalQPoints, double totCredits) {
		this.GPA = totalQPoints/totCredits;
	}

	//to String
	public String toString() {
		String myString = new String("\nName: " + this.name+ "\n" + "Major: " +this.major+"\n " + "GPA: " + this.GPA + "\n" + 
				"TotalCredits: " + this.totalCredits + "\n" + "Total Quality Points: " + this.totalQPoints + "\n");
		return myString;
	}

}

