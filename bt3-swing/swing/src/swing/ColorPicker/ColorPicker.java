/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.ColorPicker;

import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTabbedPane;

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
        
        list = new JList();
    }

    public static void main(String[] args) {
        new ColorPicker();
    }

}
