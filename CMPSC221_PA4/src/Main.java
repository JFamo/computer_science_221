
public class Main {

	public static void main(String args[]) {
		
		GuessNumber gui = new GuessNumber();
		NumberController number = new NumberController(1000);
		gui.setNumberController(number);
		
	}
	
}
