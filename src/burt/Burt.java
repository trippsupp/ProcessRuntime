package burt;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Vance Field III
 */
public class Burt {
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Create Shutdown Event");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);         // no resize
        frame.setContentPane(new GUI());   // set pane to GUI class     
        frame.setPreferredSize(new Dimension(300, 100));
        frame.pack();                      // pack the frame 
        frame.setLocationRelativeTo(null); // sets app to middle of the screen
        frame.setVisible(true);            // set frame visible
    }
    
}
