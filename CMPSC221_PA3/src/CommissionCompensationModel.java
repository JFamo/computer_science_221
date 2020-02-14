// This Compensation Model subclass takes a commission rate multiplied by gross sales to calculate earnings

public class CommissionCompensationModel extends CompensationModel {
	
	// Attributes
	private double grossSales;
	private double commissionRate;
	
	// Constructor takes gross sales as a double and commission rate as a double
	public CommissionCompensationModel(double grossSales, double commissionRate) {
		super();
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	// Earnings method takes no args and returns a calculated earnings as a double
	public double earnings() {
		
		return grossSales * commissionRate;
		
	}
	
	// Raise takes percentage raise as a double arg and returns nothing. It increases commission rate by the percent specified
	public void raise(double percent) {
		
		commissionRate += commissionRate * percent;
		
	}

	// The toString method returns object attributes as a string and takes no arguments
	public String toString() {
		
		return "Commission Compensation with:\nGross Sales of: " + grossSales + "\nCommmission Rate of: " + commissionRate + "\nEarnings: " + earnings();
		
	}
	
}
