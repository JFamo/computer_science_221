// This Compensation Model subclass multiplies an hourly wage by hours worked, adding 1.5 times each hour over 40 worked for overtime

public class HourlyCompensationModel extends CompensationModel {

	// Attributes
	private double wage;
	private double hours;
	
	// Constructor takes wage and hours worked as doubles
	public HourlyCompensationModel(double wage, double hours) {
		super();
		this.wage = wage;
		this.hours = hours;
	}

	// Earnings method takes no args and returns calculated earnings as a double
	public double earnings() {
		
		if(hours <= 40) {
			return wage * hours;
		}
		else {
			return (wage * 40.0) + ((1.5 * wage) * (hours - 40.0));
		}
		
	}
	
	// Raise method takes percentage raise as a double and returns nothing. Wage is increased by raise percent
	public void raise(double percent) {
		
		wage += wage * percent;
		
	}
	
	// ToString method takes no args and returns object attributes as a String
	public String toString() {
		
		return "Hourly Compensation with:\nWage of: " + wage + "\nHours Worked of : " + hours + "\nEarnings: " + earnings();
		
	}
	
}
