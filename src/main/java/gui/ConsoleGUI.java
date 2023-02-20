package gui;

import states.Context;
import states.EventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// UNFINISHED WORK: THIS CLASS NEEDS TO BE REWRITTEN TO USE ANOTHER GUI
// (NOT SWING, BUT DOING EVERYTHING DIRECTLY FROM THE CONSOLE.
public class ConsoleGUI extends AbstractGUI {
    
    private JButton b1, b2, b3;

    public ConsoleGUI(EventListener o) { super(o); }
    
    protected void initGUI() {
        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();
        JLabel myText1 = new JLabel();
        JLabel myText2 = new JLabel();
        JLabel myText3 = new JLabel();

        JFrame myFrame = new JFrame("Chronometer");
        Container myContent = myFrame.getContentPane();
        // grid layout with 2 rows and 3 columns
        myContent.setLayout(new GridLayout(2,3,1,1));
        // filling first row of grid (3 columns) with text information
        myContent.add(myText1,0);
        myContent.add(myText2,1);
        myContent.add(myText3,2);
        // filling second row of grid (3 columns) with buttons
        myContent.add(b1);
        myContent.add(b2);
        myContent.add(b3);
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }

    protected void addEventListener() {
        b1.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) {
        		observer.left();
                }
        	});
        b2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		observer.up();
                }
        	});
        b3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		observer.right();
                }
        	});
   }
    
    public void updateUI(Context c) {
    	System.out.println(
    			"Running in mode " + c.getModeText() +
    			" in state " + c.getStateText() +
    			" with value " + c.getDisplayText() );
    }
   
}
