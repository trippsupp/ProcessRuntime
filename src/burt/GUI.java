package burt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
    private final JPanel p1, p2;

    public GUI() {
        setLayout(new BorderLayout());
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


        p1 = new JPanel();
        p2 = new JPanel();
        p1.setBackground(Color.LIGHT_GRAY);
        p2.setBackground(Color.LIGHT_GRAY);

        p1.add(b3);
        p2.add(b4);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
    }

}
