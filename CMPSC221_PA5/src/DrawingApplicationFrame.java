/**
 * This program implements a drawing application using a variety of shapes, paint types, and strokes with additional functionality to undo and clear from a list of shapes.
 * 
 * @author Joshua Famous jjf5899@psu.edu
 * 
 * 3/19/2020
 *
 */

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// This class implements the frame for the drawing application with nested subclasses for other features
public class DrawingApplicationFrame extends JFrame
{

    // Create the panels for the top of the application. One panel for each
    // line and one to contain both of those panels.
	JPanel row1 = new JPanel();
	JPanel row2 = new JPanel();
	JPanel controlPanel = new JPanel();

    // create the widgets for the firstLine Panel.
	JButton undoButton = new JButton("Undo");
	JButton clearButton = new JButton("Clear");
	JLabel shapeLabel = new JLabel("Shape: ");
	JLabel filledLabel = new JLabel("Filled");
	JCheckBox filledCheckbox = new JCheckBox();
	String[] shapeOptions = {"Line","Oval","Rectangle"};
	JComboBox shapeCombobox = new JComboBox(shapeOptions);

    //create the widgets for the secondLine Panel.
	JLabel gradientLabel = new JLabel("Use Gradient");
	JCheckBox gradientCheckbox = new JCheckBox();
	JLabel dashedLabel = new JLabel("Dashed");
	JCheckBox dashedCheckbox = new JCheckBox();
	JButton firstColorButton = new JButton("1st Color...");
	JButton secondColorButton = new JButton("2nd Color...");
	JLabel widthLabel = new JLabel("Line Width:");
	JLabel dashLabel = new JLabel("Dash Length:");
	JTextField widthTextfield = new JTextField(5);
	JTextField dashTextfield = new JTextField(5);

    // Variables for drawPanel.
	Color firstColor;
	Color secondColor;

    // add status label
	JLabel statusLabel = new JLabel("0,0");
	
	// add draw panel
	DrawPanel drawPanel;
	 
    // Constructor for DrawingApplicationFrame
    public DrawingApplicationFrame()
    {
    	
    	super("Drawing Application");
    	
        // add widgets to panels
    	row1.setLayout(new FlowLayout());
    	row1.add(undoButton);
    	row1.add(clearButton);
    	row1.add(shapeLabel);
    	row1.add(shapeCombobox);
    	row1.add(filledCheckbox);
    	row1.add(filledLabel);
    	
    	row2.setLayout(new FlowLayout());
    	row2.add(gradientCheckbox);
    	row2.add(gradientLabel);
    	row2.add(firstColorButton);
    	row2.add(secondColorButton);
    	row2.add(widthLabel);
    	row2.add(widthTextfield);
    	row2.add(dashLabel);
    	row2.add(dashTextfield);
    	row2.add(dashedCheckbox);
    	row2.add(dashedLabel);
    	
        // add top panel of two panels
    	controlPanel.setLayout(new BorderLayout());
    	controlPanel.add(row1, BorderLayout.NORTH);
    	controlPanel.add(row2, BorderLayout.SOUTH);
    	
    	// Instantiate draw panel
    	drawPanel = new DrawPanel();
    	
    	// Set defaults
    	widthTextfield.setText("10");
    	dashTextfield.setText("10");
    	firstColor = Color.DARK_GRAY;
    	secondColor = Color.LIGHT_GRAY;

        // add topPanel to North, drawPanel to Center, and statusLabel to South
    	add(controlPanel, BorderLayout.NORTH);
    	add(drawPanel, BorderLayout.CENTER);
    	add(statusLabel, BorderLayout.SOUTH);
    	
    	// make visible again for delay
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720,720);
        setVisible(true);
        
        //add listeners and event handlers
        ButtonHandler buttonHandler = new ButtonHandler();
        undoButton.addActionListener(buttonHandler);
        clearButton.addActionListener(buttonHandler);
        firstColorButton.addActionListener(buttonHandler);
        secondColorButton.addActionListener(buttonHandler);
     
    }

    // Handle button events
    private class ButtonHandler implements ActionListener {
    	
    	public void actionPerformed(ActionEvent event) {
    		
    		// Undo
    		if(event.getSource() == undoButton) {
    			drawPanel.undo();
    		}
    		// Clear
    		else if(event.getSource() == clearButton) {
    			drawPanel.clear();
    		}
    		// Color Picker Buttons
    		else if(event.getSource() == firstColorButton) {
    			firstColor = JColorChooser.showDialog(DrawingApplicationFrame.this, "Choose a Color", firstColor);
    			if(firstColor == null) {
    				firstColor = Color.black;
    			}
    			firstColorButton.setBackground(firstColor);
    		}
    		else {
    			secondColor = JColorChooser.showDialog(DrawingApplicationFrame.this, "Choose a Color", secondColor);
    			if(secondColor == null) {
    				secondColor = Color.lightGray;
    			}
    			secondColorButton.setBackground(secondColor);
    		}
    		
    	}
    	
    }

    // Create a private inner class for the DrawPanel.
    private class DrawPanel extends JPanel
    {
    	
    	public ArrayList<MyShapes> shapes;
    	public Paint paint;
    	public Stroke stroke;

        public DrawPanel()
        {
        	
        	shapes = new ArrayList<MyShapes>();
        	setBackground(Color.WHITE);
        	
        	//Add mouse listener
        	MouseHandler mouseHandler = new MouseHandler();
        	addMouseListener(mouseHandler);
        	addMouseMotionListener(mouseHandler);
        	
        }

        public void paintComponent(Graphics g)
        {
        	
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            //loop through and draw each shape in the shapes arraylist
            for(MyShapes shape : shapes) {
            	
            	shape.draw(g2d);
            	
            }
            
        }

        // Undo function, removes last shape
        public void undo() {
        	if(shapes.size() > 0) {
        		shapes.remove(shapes.size() - 1);
        	}
        	repaint();
        }
        
        // Clear function, removes all shapes
        public void clear() {
        	shapes.clear();
        	repaint();
        }
        
        // Handler for mouse movement and action events
        private class MouseHandler extends MouseAdapter implements MouseMotionListener
        {
        	
            public void mousePressed(MouseEvent event)
            {
            	// Get line width and dash length
            	int lineWidth;
            	try {
            		lineWidth = Integer.parseInt(widthTextfield.getText());
            	}catch(NumberFormatException e) {
            		lineWidth = 10;
            	}
            	float[] dashLength = new float[1];
            	try{
            		dashLength[0] = Float.parseFloat(dashTextfield.getText());
            	}catch(NumberFormatException e) {
            		dashLength[0] = 10.0f;
            	}
            	
            	// Set paint
            	if(gradientCheckbox.isSelected()) {
            		paint = new GradientPaint(0, 0, firstColor, 50, 50, secondColor, true);
            	}
            	else {
            		paint = firstColor;
            	}
            	
            	// Set stroke
            	if(dashedCheckbox.isSelected()) {
            		stroke = new BasicStroke(lineWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashLength, 0);
            	}
            	else {
            		stroke = new BasicStroke(lineWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            	}
            	
            	// Find draw type
            	if(shapeCombobox.getItemAt(shapeCombobox.getSelectedIndex()) == "Line") {
            		shapes.add(new MyLine(event.getPoint(), event.getPoint(), paint, stroke));
            	}
            	else if(shapeCombobox.getItemAt(shapeCombobox.getSelectedIndex()) == "Oval") {
            		shapes.add(new MyOval(event.getPoint(), event.getPoint(), paint, stroke, filledCheckbox.isSelected()));
            	}
            	else {   
            		shapes.add(new MyRectangle(event.getPoint(), event.getPoint(), paint, stroke, filledCheckbox.isSelected()));
            	}
            	
            	System.out.println(shapes);
            	repaint();
            	
            }

            public void mouseReleased(MouseEvent event)
            {
            	
            }

            @Override
            public void mouseDragged(MouseEvent event)
            {
            	shapes.get(shapes.size() - 1).setEndPoint(event.getPoint());
            	repaint();
            }

            @Override
            public void mouseMoved(MouseEvent event)
            {
            	
            	statusLabel.setText(event.getPoint().x + "," + event.getPoint().y);
            	
            }
        }

    }
}
