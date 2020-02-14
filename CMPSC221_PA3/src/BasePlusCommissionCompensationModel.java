// This Compensation Model subclass takes a base salary and commission multiplied by gross sales to calculate earnings

public class BasePlusCommissionCompensationModel extends CompensationModel {
	
	// Attributes
	private double grossSales;
	private double commissionRate;
	private double baseSalary;

	// Constructor takes double gross sales, double commission rate, and double base salary
	public BasePlusCommissionCompensationModel(double grossSales, double commissionRate, double baseSalary) {
		super();
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
		this.baseSalary = baseSalary;
	}
	
	// Earnings method takes no args and returns earnings as double
	public double earnings() {
		
		return baseSalary + (grossSales * commissionRate);
		
	}
	
	// Raise method takes percent arg as a double and returns nothing. It increases commission rate and base salary by the percentage specified
	public void raise(double percent) {
		
		commissionRate += commissionRate * percent;
		baseSalary += baseSalary * percent;
		
	}

	// The toString method returns object attributes as a string and takes no arguments
	public String toString() {
		
		return "Base Plus Commission Compensation with:\nGross Sales of: " + grossSales + "\nCommmission Rate of: " + commissionRate + "\nBase Salary of: " + baseSalary + "\nEarnings: " + earnings();
		
	}
	
}
