/**
 * This program implements a GUI for a guess-the-number game where the user tries to guess a randomly generated integer between 1 and 1000.
 * 
 * @author Joshua Famous jjf5899@psu.edu
 * 
 * 2/27/2020
 *
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// The GuessNumber class implements the GUI for the program and extends JFrame
public class GuessNumber extends JFrame {
	
	// Declare GUI elements
	private final JLabel labelInitial;
	private final JLabel labelProximity;
	private final JTextField inputGuess;
	private final JButton buttonPlayAgain;
	
	// Declare panels
	private final JPanel firstRow;
	private final JPanel secondRow;
	private final JPanel thirdRow;
	
	// Declare other properties
	private int lastGuess;
	private NumberController number;
	
	// Constructor for GuessNumber configures GUI
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
		ReplayHandler replayHandler = new ReplayHandler();
		buttonPlayAgain.addActionListener(replayHandler);
		
		// Reset game states
		resetGame();
		
		// Set frame display options
		setLocationRelativeTo(null);
		setSize(1024, 256);
		setVisible(true);
	}
	
	// This method resets the game state to play again, takes no arguments, and returns nothing
	public void resetGame() {
		
		inputGuess.setEditable(true);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		labelProximity.setText("");
		labelInitial.setText("I have a number between 1 and 1000. Can you guess my number? Please enter your first guess.");
		buttonPlayAgain.setVisible(false);
		lastGuess = -99999;
		
	}
	
	// This method sets the game state to its win condition, takes no arguments, and returns nothing
	public void triggerWin() {
		
		inputGuess.setEditable(false);
		getContentPane().setBackground(Color.YELLOW);
		labelProximity.setText("Correct!");
		buttonPlayAgain.setVisible(true);
		
	}
	
	// This mutator sets the number controller for the game, takes a NumberController argument, and returns nothing
	public void setNumberController(NumberController number) {
		
		this.number = number;
		
	}
	
	// Nested class ReplayHandler handles plain button event for Play Again and resets game state
	private class ReplayHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			resetGame();
			number.setNumber(1000);
			
		}
		
	}
	
	// Nested class GuessHandler handles JTextField events
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