package studio9;

import assignment7.Student;

import java.util.HashMap;
import java.util.Map;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions

	private final Map<String, Student> database; 
	
	public UniversityDatabase() {
		this.database = new HashMap<>();
	}
	
	public void addStudent(String accountName, Student student) {
		database.put(accountName, student);
	}

	public int getStudentCount() {
		return database.size();
	}

	public String lookupFullName(String accountName) {
		if (database.get(accountName) == null) {
			return null;
		}
		else {
			return database.get(accountName).getFullName();
		}
	}

	public double getTotalBearBucks() {
		
		double total = 0; 
		
		for (Student s : database.values()) {
			total += s.getBearBucksBalance();
		}

		return total;
	}
}
