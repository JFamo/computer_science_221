/**
 * This program implements a GUI for a guess-the-number game where the user tries to guess a randomly generated integer between 1 and 1000.
 * 
 * @author Joshua Famous jjf5899@psu.edu
 * 
 * 2/27/2020
 *
 */

import java.util.Random;

// NumberController sets and saves a random number between 1 and 1000.
public class NumberController {
	
	private int myNumber;

	// Constructor for NumberController, takes integer arg for maximum bound (inclusive)
	public NumberController(int max) {
		
		setNumber(max);
		
	}
	
	// Method to set random number between 1 and int max (inclusive). Takes max as argument and returns nothing
	public void setNumber(int max) {
		
		Random r = new Random();
		myNumber = r.nextInt(max) + 1;
		
	}
	
	// Method to check guess, takes integer guess and returns 1 for correct guess, 0 for low guess, and 2 for high guess
	public int checkGuess(int guess) {
		
		if(guess == myNumber) {
			
			return 1; // Case for correct guess
			
		}
		else if(guess < myNumber) {
			
			return 0; // Case for low guesses
			
		}
		return 2; // Case for high guesses
		
	}
	
	// Method to return whether this guess is closer than last. Takes integer params for current and previous guess and returns a boolean
	public boolean closer(int guess, int lastGuess) {
		
		if(Math.abs(guess - myNumber) < Math.abs(lastGuess - myNumber)) {
			return true;
		}
		return false;
		
	}
	
}
