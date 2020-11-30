/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.test;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author phamthainb
 */
public class Test {
    private JFrame frame;
    private JButton btn;
    
    public Test(){
        // make btn
        btn = new JButton("Click here");
        btn.setBounds(130,100,200, 40);
        btn.setBackground(Color.green);
        // make window
        frame = new JFrame("Test App");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        
        // add
        frame.add(btn);
        
    }
}
