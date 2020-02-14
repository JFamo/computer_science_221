/**
 * This program replicates an employee pay structure using various Compensation Models and assigning them to employees to calculate earnings using inheritance.
 * 
 * @author Joshua Famous jjf5899@psu.edu
 * 
 * 2/6/2020
 *
 */

// The BasePlusCommissionCompensationModel class is a child of CommisssionCompensationModel which adds a base salary to the earnings
public class BasePlusCommissionCompensationModel extends CommissionCompensationModel {

	// Attributes
	private double baseSalary;
	
	// Constructor for BasePlusCommissionCompensationModel takes Gross Sales as a double, Commission Rate as a double, and Base Salary as a double and creates BasePlusCommissionCompensationModel object
	public BasePlusCommissionCompensationModel(double grossSales, double commissionRate, double baseSalary) {

		super(grossSales, commissionRate);
		this.baseSalary = baseSalary;
		
	}

	// The earnings method returns the quantity gross sales times the commission rate plus the base salary as a double and takes no input
	public double earnings() {
		
		return super.earnings() + baseSalary;
		
	}
	
	// The ToString method returns a description of the BasePlusCommissionCompensationModel object as a String and takes no input
	public String toString() {
		
		return "Base Plus Commission Compensation with:\nGross Sales of: " + super.getGrossSales() + "\nCommmission Rate of: " + super.getCommissionRate() + "\nBase Salary of: " + baseSalary + "\nEarnings: " + earnings();
		
	}
	
}
