/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.ColorPicker;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author phamthainb
 */
public class ColorPicker extends JFrame {

    private JFrame frame;
    private JList list;
    private JComboBox combox;
    private JColorChooser colorChoose;

    // make tabs
    private JTabbedPane tabs;

    public ColorPicker() {
        createAndShow();
    }

    private void createAndShow() {
        // init window
        frame = new JFrame("Color Picker");
        frame.setSize(400, 400); // set size
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //make tabs control
        tabs = new JTabbedPane();

        /* create three JPanel, which is content of tabs */
        JPanel panel2 = createJPanel("content of panel 2");
        JPanel panel3 = createJPanel("content of panel 3");

        /* add three tab with three JPanel */
        tabs.addTab("Tab 2", null, panel2, "click to show panel 2");
        tabs.addTab("Tab 3", null, panel3, "click to show panel 3");

        // window add
        frame.add(tabs);
    }

    private JPanel createJPanel(String text) {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        JLabel lb = new JLabel(text);
        lb.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lb);
        return panel;
    }

    private void withList() {

    }

    public static void main(String[] args) {
        new ColorPicker();
    }

}
