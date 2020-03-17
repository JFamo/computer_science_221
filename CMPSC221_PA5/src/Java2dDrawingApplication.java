/**
 * This program implements a drawing application using a variety of shapes, paint types, and strokes with additional functionality to undo and clear from a list of shapes.
 * 
 * @author Joshua Famous jjf5899@psu.edu
 * 
 * 3/19/2020
 *
 */
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

// This class runs the drawing application
public class Java2dDrawingApplication
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        DrawingApplicationFrame frame = new DrawingApplicationFrame();
        frame.setLayout(new BorderLayout());
    }
    
}
