package assignment7;

public class Student {
	
	private String firstName;
	private String lastName;
	private int studentIDNumber;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGradeQualityPoints;
	private double bearBucksBalance;
	
	public Student (String firstName, String lastName, int studentIDNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentIDNumber = studentIDNumber;
	}
	
	/**
	 * Student's first and last name
	 * @return student's first and last name
	 */
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	/**
	 * student's ID number
	 * @return student's ID number
	 */
	public int getId() {
		return this.studentIDNumber;
	}
	
	/**
	 * calculating attempted credits, passing credits, an total grade quality points
	 * @param grade student's grade for a course
	 * @param credits total number of credits student received
	 */
	public void submitGrade (double grade, int credits) {
		this.attemptedCredits = this.attemptedCredits + credits;
		
		if (grade >= 1.7) {
			this.passingCredits = this.passingCredits + credits;
		}
		this.totalGradeQualityPoints = this.totalGradeQualityPoints + (grade * credits);
	}
	
	/**
	 * total attempted credits
	 * @return total attempted credits
	 */
	public int getTotalAttemptedCredits() {
		return this.attemptedCredits;
	}
	
	/**
	 * total passing credits
	 * @return total attempted credits
	 */
	public int getTotalPassingCredits() {
		return this.passingCredits;
	}
	
	/**
	 * Calculating grade point average for a student
	 * @return grade point average
	 */
	public double calculateGradePointAverage() {
		return this.totalGradeQualityPoints / this.attemptedCredits;
	}
	
	/**
	 * gives student's current year in school
	 * @return student's current year in school
	 */
	public String getClassStanding() {
		if (this.passingCredits < 30) {
			return "First Year";
		}
		else if (this.passingCredits >= 30 && this.passingCredits < 60) {
			return "Sophomore";
		}
		else if (this.passingCredits >= 60 && this.passingCredits < 90) {
			return "Junior";
		}
		else if (this.passingCredits >= 90) {
			return "Senior";
		}
		else {
			return null;
		}
	}
	
	/**
	 * checks if student is eligible for Phi Beta Kappa with their number of passing credits and total grade quality points
	 * @return true if student is eligible, false if not
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (this.passingCredits >= 98 && (this.totalGradeQualityPoints / this.attemptedCredits) >= 3.60){
			return true;
		}
		else if (this.passingCredits >= 75 && (this.totalGradeQualityPoints / this.attemptedCredits) >= 3.80) { 
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * adds amount into Bear Bucks balance
	 * @param amount amount of money added
	 * @return new Bear Bucks balance
	 */
	public void depositBearBucks (double amount) {
		this.bearBucksBalance = this.bearBucksBalance + amount;
	}
	
	/**
	 * subtracts amount from Bear Bucks balance
	 * @param amount amount of money subtracted
	 * @return new Bear Bucks balance
	 */
	public void deductBearBucks (double amount) {
		this.bearBucksBalance = this.bearBucksBalance - amount;
	}
	
	/**
	 * Bear Bucks balance
	 * @return Bear Bucks balance
	 */
	public double getBearBucksBalance() {
		return this.bearBucksBalance;
	}
	
	/**
	 * money cashed out from Bear Bucks balance
	 * @return money cashed out from Bear Bucks balance
	 */
	public double cashOutBearBucks() {
		double temporaryValue = this.bearBucksBalance;
		
		this.bearBucksBalance = 0.00;
		
		if (temporaryValue > 10.00) {
			return temporaryValue - 10.00;
		}
		else if (temporaryValue == 10.00) {
			return 0.00;
		}
		else {
			return 0.00;
		}
	}
	
	/**
	 * puts parent's last name as student's last name
	 * @param lastName parent's last name
	 */
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * parent's last name
	 * @return parent's last name
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * uses two existing students' information and creates legacy name, checks if last name needs to be hyphenated, creates a student ID, creates Bear Bucks balance
	 * @param firstName legacy's first name
	 * @param other second parent
	 * @param isHyphenated if legacy's last name needs to be hyphenated
	 * @param id legacy's student ID number
	 * @return true if last name needs to be hyphenated, false if not
	 * @return legacy's first & last name and student ID
	 */
	public Student createLegacy (String firstName, Student other, boolean isHyphenated, int id) {
		String childLastName = " ";
		
		if (isHyphenated == true) {
			childLastName = this.lastName + "-" + other.getLastName();
		}
		else {
			childLastName = this.lastName;
		}
		
		double childBearBucksBalance = this.cashOutBearBucks() + other.cashOutBearBucks();
		Student child = new Student (firstName, childLastName, id);
		child.depositBearBucks(childBearBucksBalance);
		return child;
	}
	
	/**
	 * gives student's first & last name and student ID
	 * @return name of the course and number of credits it comes with
	 */
	public String toString() {
		return this.firstName + " " + this.lastName + "'s ID Number: " + this.studentIDNumber;
	}
}