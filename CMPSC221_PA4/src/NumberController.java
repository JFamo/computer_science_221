import java.util.Random;

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
	
	public boolean closer(int guess, int lastGuess) {
		
		if(Math.abs(guess - myNumber) < Math.abs(lastGuess - myNumber)) {
			return true;
		}
		return false;
		
	}
	
}
