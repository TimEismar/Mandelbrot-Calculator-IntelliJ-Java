// Java program to demonstrate GridBagLayout class.
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

// Constructor of GridBagLayout class.
public class GridBag {

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    public static void addComponentsToPane(Container pane)
    {

        // if condition
        if (RIGHT_TO_LEFT) {

            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        // Declaration of objects of JButton class
        JButton button;

        // set the layout
        pane.setLayout(new GridBagLayout());

        // creates a constraints object
        GridBagConstraints c = new GridBagConstraints();

        // if condition
        if (shouldFill) {

            // natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        // Initialization of object
        // "button" of JButton class.
        button = new JButton("Button 1");

        // if condition
        if (shouldWeightX) {
            c.weightx = 0.5;
        }

        // column 0
        c.gridx = 0;

        // row 0
        c.gridy = 0;

        // Adding JButton "button" on JFrame.
        pane.add(button, c);

        // Initialization of object
        // "button" of JButton class.
        button = new JButton("Button 2");

        // column 1
        c.gridx = 1;

        // row 0
        c.gridy = 0;

        // Adding JButton "button" on JFrame.
        pane.add(button, c);

        // Initialization of object
        // "button" of JButton class.
        button = new JButton("Button 3");

        // column 1
        c.gridx = 2;

        // row 0
        c.gridy = 0;

        // Adding JButton "button" on JFrame.
        pane.add(button, c);

        // Initialization of object
        // "button" of JButton class.
        button = new JButton("Long-Named Button 4");

        // increases components height by 40 pixels
        c.ipady = 40;

        // column width 0
        c.weightx = 0.0;

        // row width 3
        c.gridwidth = 3;

        // column 1
        c.gridx = 0;

        // row 1
        c.gridy = 1;

        // Adding JButton "button" on JFrame.
        pane.add(button, c);

        // Initialization of object
        // "button" of JButton class.
        button = new JButton("Button 5");

        // increases components height by 0 pixels
        c.ipady = 0;

        // request any extra vertical space
        c.weighty = 1.0;

        // bottom of space
        c.anchor = GridBagConstraints.PAGE_END;

        // top padding
        c.insets = new Insets(10, 0, 0, 0);

        // column 2
        c.gridx = 1;

        // 2 columns wide
        c.gridwidth = 2;

        // row 3
        c.gridy = 2;

        // Adding JButton "button" on JFrame.
        pane.add(button, c);
    }

    // Create the GUI and show it. For thread safety,
// this method should be invoked from the
// event-dispatching thread.
    private static void createAndShowGUI()
    {

        // to set a Jframe default
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");

        // Function to close the operation of JFrame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adding the content pane.
        addComponentsToPane(frame.getContentPane());

        // Display the window.
        frame.pack();

        // Function to set visible status of JFrame.
        frame.setVisible(true);
    }

    // Main Method
    public static void main(String[] args)
    {

        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}
