package burt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Vance Field III
 */
public class GUI extends JPanel {


    private final JButton b3, b4;

    public GUI() {
        setLayout(new FlowLayout());
        setBackground(Color.lightGray);

        b3 = new JButton("shutdown");
        b4 = new JButton("stop shutdown");
     
        b3.setPreferredSize(new Dimension(100, 50));
        b4.setPreferredSize(new Dimension(100, 50));
        
        b3.setMargin(new Insets(0, 0, 0, 0));
        b4.setMargin(new Insets(0, 0, 0, 0));

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    Process proc = runtime.exec("shutdown -s -t 120");
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                // System.exit(0);
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    Process proc = runtime.exec("shutdown -a");
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });




        add(b3);
        add(b4);

    }

}
