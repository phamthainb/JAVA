/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.utlis;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author phamthainb
 */
public class MakeTabs {
    private JTabbedPane tabs;
    
    public MakeTabs() {
        tabs = new JTabbedPane();
        
        /* create three JPanel, which is content of tabs */
        JPanel panel2 = createJPanel("content of panel 2");
        JPanel panel3 = createJPanel("content of panel 3");
 
        /* add three tab with three JPanel */
        tabs.addTab("Tab 2", null, panel2, "click to show panel 2");
        tabs.addTab("Tab 3", null, panel3, "click to show panel 3");
    }

    private JPanel createJPanel(String text) {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        JLabel lb = new JLabel(text);
        lb.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lb);
        return panel;
    }
    
}
