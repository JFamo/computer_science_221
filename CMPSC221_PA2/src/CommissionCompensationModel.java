/**
 * This program replicates an employee pay structure using various Compensation Models and assigning them to employees to calculate earnings using inheritance.
 * 
 * @author Joshua Famous jjf5899@psu.edu
 * 
 * 2/6/2020
 *
 */

// The CommissionCompensationModel class represents a compensation model based on just gross sales and a commission rate
public class CommissionCompensationModel {
	
	// Attributes
	private double grossSales;
	private double commissionRate;
	
	// Constructor takes Gross Sales as a double and Commission Rate as double to create CommissionCompensationModel
	public CommissionCompensationModel(double grossSales, double commissionRate) {

		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
		
	}
	
	// Getter for Gross Sales as double
	public double getGrossSales() {
		return grossSales;
	}

	// Setter for Gross Sales takes double
	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	// Getter for Commission Rate as double
	public double getCommissionRate() {
		return commissionRate;
	}

	// Setter for Commission Rate takes double
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	// Earnings method returns the gross sales times the commission rate as a double and takes no input
	public double earnings() {
		
		return grossSales * commissionRate;
		
	}
	
	// ToString method returns CommissionCompensationModel object description as String and takes no input
	public String toString() {
		
		return "Commission Compensation with:\nGross Sales of: " + grossSales + "\nCommmission Rate of: " + commissionRate + "\nEarnings: " + earnings();
		
	}
	
}
