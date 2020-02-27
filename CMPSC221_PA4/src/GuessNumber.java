import java.awt.*;
import javax.swing.*;

public class GuessNumber {
	
	public static void main(String args[]) {
		
		// Create GUI objects
		JFrame frame = new JFrame("Guess the Number Game");
		JLabel labelInitial = new JLabel("I have a number between 1 and 1000. Can you guess my number?\nPlease enter your first guess.", JLabel.CENTER);
		JLabel labelProximity = new JLabel("Too high!");
		JTextField inputGuess = new JTextField("",4);
		
		// Set object display options
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(labelInitial, BorderLayout.CENTER);
		frame.getContentPane().add(inputGuess, BorderLayout.CENTER);
		
		// Set frame display options
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	
}
