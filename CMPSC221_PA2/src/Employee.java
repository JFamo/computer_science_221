/**
 * This program replicates an employee pay structure using various Compensation Models and assigning them to employees to calculate earnings using inheritance.
 * 
 * @author Joshua Famous jjf5899@psu.edu
 * 
 * 2/6/2020
 *
 */

// The Employee class contains information about an individual employee including SSID, first and last name, and a compensation model reference
public class Employee {

	// Employee attributes
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private CommissionCompensationModel commissionCompensationModel;
	
	// Constructor for employee which takes a String First Name, String Last Name, String SSID, and Commission Model
	public Employee(String firstName, String lastName, String socialSecurityNumber, CommissionCompensationModel commissionCompensationModel) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.commissionCompensationModel = commissionCompensationModel;
		
	}
	
	// Method to calculate earnings based on compensation model; takes no input and returns earnings as a double
	public double earnings() {
		
		return commissionCompensationModel.earnings();
		
	}
	
	// Method to display employee object as string; takes no input and returns object description as String
	public String toString() {
		
		return firstName + " " + lastName + "\nSocial Security Number: " + socialSecurityNumber + "\n" + commissionCompensationModel.toString() + "\n";
		
	}
	
	// Getter for First Name as String
	public String getFirstName() {
		return firstName;
	}

	// Setter for First Name as String
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Getter for Last Name as String
	public String getLastName() {
		return lastName;
	}

	// Setter for Last Name as String
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Getter for SSID as String
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	// Setter for SSID as String
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	// Getter for Compensation Model, returns object of CommissionCompensationModel
	public CommissionCompensationModel getCommissionCompensationModel() {
		return commissionCompensationModel;
	}

	// Setter for Compensation Model, takes object of CommissionCompensationModel
	public void setCompensation(CommissionCompensationModel commissionCompensationModel) {
		this.commissionCompensationModel = commissionCompensationModel;
	}
	
}
