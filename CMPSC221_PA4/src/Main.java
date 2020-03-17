/**
 * This program implements a GUI for a guess-the-number game where the user tries to guess a randomly generated integer between 1 and 1000.
 * 
 * @author Joshua Famous jjf5899@psu.edu
 * 
 * 2/27/2020
 *
 */

// The Main class runs the program and instantiates the GUI and number
public class Main {

	// Main method
	public static void main(String args[]) {
		
		// Create GUI, random number, and add number controller to GUI
		GuessNumber gui = new GuessNumber();
		NumberController number = new NumberController(1000);
		gui.setNumberController(number);
		
	}
	
}
