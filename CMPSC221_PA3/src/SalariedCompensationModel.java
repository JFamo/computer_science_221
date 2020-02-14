// This Compensation Model subclass returns a weekly salary for earnings

public class SalariedCompensationModel extends CompensationModel {

	// Attributes
	private double weeklySalary;
	
	// Constructor takes weekly salary as a double
	public SalariedCompensationModel(double weeklySalary) {
		
		super();
		this.weeklySalary = weeklySalary;
		
	}

	// Earnings method takes no args and returns weekly salary as a double
	public double earnings() {
		
		return weeklySalary;
		
	}
	
	// Raise method takes percentage raise as a double and returns nothing. Weekly salary is increased by raise percent
	public void raise(double percent) {
		
		weeklySalary += weeklySalary * percent;
		
	}
	
	// ToString method takes no args and returns object attributes as a String
	public String toString() {
		
		return "Salaried Compensation with:\nWeekly Salary of: " + weeklySalary + "\nEarnings: " + earnings();
		
	}
	
}
