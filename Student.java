package database;

public class Student {

	private String name;
	private String major;
	private int grades;
	private int credits;
	private int GPA=4;
	private int totalCredits;
	private int totalQPoints;
	private int totalGrades;
	private int newCredit;
	private int newTotalQPoints;
	
	public Student() {
		
	}
	
	public Student (String name, String major) {
		this.name = name;
		this.major = major;
		this.GPA = 0;
		this.totalCredits = doTotalCredits();
		this.totalQPoints = doTotalQPoints();
	}
//getter methods
	public int getGrades() {
		return grades;
	}
	public int getCredits() {
		return credits;
	}
	public int getTotalCredits() {
		return totalCredits;
	}
	public int getTotalQPoints() {
		return totalQPoints;
	}
	public int getNewCredit() {
		return newCredit;
	}
	
	public void courseCompleted(int grade, int credit) {
		this.totalCredits = this.totalCredits+credit;
		this.totalGrades = this.totalGrades+grade;
		setGPA();
	}
	
	public int getGPA() {
		return GPA;
	}
	
//setter methods
	public void setGrades(int grades) {
		this.grades = grades;
	}
	public void setCredits(int credits) {
		this.credits= credits;
	}
	public void setTotalCredits(int totalCredits) {
		this.totalCredits=totalCredits;
	}
	public void setTotalQPoints(int totalQPoints) {
		this.totalQPoints=totalQPoints;
	}
	public void setNewCredit(int newCredit) {
		this.newCredit = newCredit;
	}
	public void setGPA() {
		this.GPA = (this.totalGrades*this.totalCredits)/this.totalCredits;
	}

//compute values
	public int doTotalCredits() {
		totalCredits = credits + getNewCredit();
		return totalCredits;
	}
	public int doTotalQPoints() {
		//TODO compute totalQPoints
		return totalQPoints;
	}
}

