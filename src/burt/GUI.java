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


    private final JButton shutdown, stopShutdown;

    public GUI() {
        setLayout(new FlowLayout());
        setBackground(Color.lightGray);

        shutdown = new JButton("shutdown");
        stopShutdown = new JButton("stop shutdown");
     
        shutdown.setPreferredSize(new Dimension(100, 50));
        stopShutdown.setPreferredSize(new Dimension(100, 50));
        
        shutdown.setMargin(new Insets(0, 0, 0, 0));
        stopShutdown.setMargin(new Insets(0, 0, 0, 0));

        shutdown.addActionListener(new ActionListener() {
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

        stopShutdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    Process proc = runtime.exec("shutdown -a");
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });




        add(shutdown);
        add(stopShutdown);

    }

}
