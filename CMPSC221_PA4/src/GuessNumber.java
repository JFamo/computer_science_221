import java.awt.*;
import javax.swing.*;

public class GuessNumber extends JFrame {
	
	private final JLabel labelInitial;
	private final JLabel labelProximity;
	private final JPanel contentPane;
	private final JTextField inputGuess;
	private final JButton buttonGuess;
	private final JButton buttonPlayAgain;
		
	public GuessNumber() {
		
		// Create frame
		super("Guess the Number Game");
		setLayout(new FlowLayout());
		
		// Create and configure content pane panel
		contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(500,400));
		contentPane.setBackground(new Color(51,102,255));
		
		// Create labels
		labelInitial = new JLabel("I have a number between 1 and 1000. Can you guess my number? Please enter your first guess.");
		labelProximity = new JLabel("Too high!");
		
		// Create text field
		inputGuess = new JTextField(4);
		
		// Create buttons
		buttonGuess = new JButton("Guess");
		buttonPlayAgain = new JButton("Play Again");
	
		// Set object display options
		contentPane.add(labelInitial);
		contentPane.add(labelProximity);
		contentPane.add(inputGuess);
		contentPane.add(buttonGuess);
		contentPane.add(buttonPlayAgain);
		
		// Set frame display options
		add(labelInitial);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
	
}
