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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Vance Field III
 */
public class GUI extends JPanel {

    private JPanel nPanel, sPanel;
    
    private final JButton shutdown, stopShutdown;
    private JCheckBox checkbox1, checkbox2;

    public GUI() {
        setLayout(new BorderLayout());
        //setBackground(Color.lightGray);

        shutdown = new JButton("Shutdown");
        stopShutdown = new JButton("Stop shutdown");
     
        shutdown.setPreferredSize(new Dimension(100, 25));
        stopShutdown.setPreferredSize(new Dimension(100, 25));
        
        shutdown.setMargin(new Insets(0, 0, 0, 0));
        stopShutdown.setMargin(new Insets(0, 0, 0, 0));
        
        checkbox1 = new JCheckBox("Custom countdown");
        checkbox2 = new JCheckBox("Custom message");

        shutdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // creates runtime object
                    Runtime runtime = Runtime.getRuntime();
                    // create default execution statement
                    String execStatement = "shutdown -s";
                    
                    // if custom time is checked
                    if(checkbox1.isSelected()){
                        String time = JOptionPane.showInputDialog(null,
                                "Enter custom time in seconds:");       
                        execStatement += " -t " + time;
                    } 
                    
                    // if custom time is NOT checked
                    else {
                        execStatement += " -t 60"; // default time of 60 seconds
                    }
                    
                    // if custom message is checked
                    if(checkbox2.isSelected()){
                        String msg = JOptionPane.showInputDialog(null,
                                "Enter custom message:");
                        execStatement += " -c " + msg;
                    }                             
                    
                    // process object executes shutdown statement
                    Process proc = runtime.exec(execStatement); 
                    
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                // System.exit(0);
            }
        });

        stopShutdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // creates runtime object
                    Runtime runtime = Runtime.getRuntime();
                    // projecss object stops shutdown
                    Process proc = runtime.exec("shutdown -a"); 
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        nPanel = new JPanel();
        sPanel = new JPanel();        
        
        // add components to west panel
        nPanel.add(shutdown);
        nPanel.add(new JLabel("   "));
        nPanel.add(stopShutdown);
        
        // add components to east panel
        sPanel.add(checkbox1);
        sPanel.add(checkbox2);        
        
        // add panels to this
        add(nPanel, BorderLayout.NORTH);
        add(sPanel, BorderLayout.SOUTH);
        
        
        
        
        
    }

}
