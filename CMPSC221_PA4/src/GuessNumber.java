import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuessNumber extends JFrame {
	
	private final JLabel labelInitial;
	private final JLabel labelProximity;
	private final JTextField inputGuess;
	private final JButton buttonPlayAgain;
	
	private final JPanel firstRow;
	private final JPanel secondRow;
	private final JPanel thirdRow;
	
	private int lastGuess;
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
		
		// Create JPanel rows
		firstRow = new JPanel();
		secondRow = new JPanel();
		thirdRow = new JPanel();
		
		// Add items to panels
		firstRow.add(labelInitial);
		secondRow.add(labelProximity);
		thirdRow.add(inputGuess);
		thirdRow.add(buttonPlayAgain);
		
		// Scale rows
		firstRow.setSize(1024, 64);
		secondRow.setSize(1024, 64);
		thirdRow.setSize(1024, 128);
		
		// Add panels to flow layout
		add(firstRow);
		add(secondRow);
		add(thirdRow);
		
		// Setup handlers
		GuessHandler guessHandler = new GuessHandler();
		inputGuess.addActionListener(guessHandler);
		
		// Reset game states
		resetGame();
		
		// Set frame display options
		setLocationRelativeTo(null);
		setSize(1024, 256);
		setVisible(true);
	}
	
	public void resetGame() {
		
		inputGuess.setEditable(true);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		labelProximity.setText("");
		labelInitial.setText("I have a number between 1 and 1000. Can you guess my number? Please enter your first guess.");
		buttonPlayAgain.setVisible(false);
		lastGuess = -99999;
		
	}
	
	public void triggerWin() {
		
		inputGuess.setEditable(false);
		getContentPane().setBackground(Color.YELLOW);
		labelProximity.setText("Correct!");
		buttonPlayAgain.setVisible(true);
		
	}
	
	public void setNumberController(NumberController number) {
		
		this.number = number;
		
	}
	
	private class GuessHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
			// Handler for JTextField inputGuess
			if(event.getSource() == inputGuess) {
				
				// Get guess
				int guess = Integer.parseInt(inputGuess.getText());
				
				// Update text
				labelInitial.setText("I have a number between 1 and 1000. Can you guess my number? Please enter your next guess.");
				
				// Check temperature, whether we are hotter or colder
				if(number.closer(guess, lastGuess)) {
					getContentPane().setBackground(Color.RED);
				}
				else {
					getContentPane().setBackground(Color.BLUE);
				}
				lastGuess = guess;
				
				// Check whether we are high low or correct
				int result = number.checkGuess(guess);
				if(result == 0) {
					
					labelProximity.setText("Too Low!");
					
				}
				else if(result == 1) {
					
					triggerWin();
	
				}
				else {
					
					labelProximity.setText("Too High!");
					
				}
				
			}
			
		}
		
	}
	
}