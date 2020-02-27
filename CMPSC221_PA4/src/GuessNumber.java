import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuessNumber extends JFrame {
	
	private final JLabel labelInitial;
	private final JLabel labelProximity;
	private final JTextField inputGuess;
	private final JButton buttonPlayAgain;
	private NumberController number;
		
	public GuessNumber() {
		
		// Create frame
		super("Guess the Number Game");
		setLayout(new FlowLayout());
		
		// Create labels
		labelInitial = new JLabel("I have a number between 1 and 1000. Can you guess my number? Please enter your first guess.");
		labelProximity = new JLabel("Too high!");
		
		// Create text field
		inputGuess = new JTextField(4);
		
		// Create buttons
		buttonPlayAgain = new JButton("Play Again");
		
		// Add to frame
		add(labelInitial);
		add(labelProximity);
		add(inputGuess);
		add(buttonPlayAgain);
		
		// Setup handlers
		GuessHandler guessHandler = new GuessHandler();
		inputGuess.addActionListener(guessHandler);
		
		// Set frame display options
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
	
	public void triggerWin() {
		
		inputGuess.setEditable(false);
		setBackground(Color.YELLOW);
		
	}
	
	public void setNumberController(NumberController number) {
		
		this.number = number;
		
	}
	
	private class GuessHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == inputGuess) {
				
				int guess = Integer.parseInt(inputGuess.getText());
				int result = number.checkGuess(guess);
				if(result == 0) {
					
					System.out.println("Low!");
					
				}
				else if(result == 1) {
					
					System.out.println("Correct!");
					
				}
				else {
					
					System.out.println("High!");
					
				}
				
			}
			
		}
		
	}
	
}