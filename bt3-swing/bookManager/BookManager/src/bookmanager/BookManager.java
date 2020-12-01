/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmanager;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phamthainb
 */
public class BookManager extends JFrame {

    private JLabel creditLabel, nameLabel, typeLabel, comboBoxLabel;
    private JButton saveButton, showButton;
    private JTable outputTable;
    private JPanel inputPanel, controlPanel;
    private JTextArea nameTxt, typeTxt, creditTxt;
    private JComboBox comboBox;
    private DefaultTableModel model;

    public BookManager() {
        // make window container
        setSize(800, 500);
        setLayout(new FlowLayout());
//        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // create table
        Vector<String> cols = new Vector<>();
        cols.add("id");
        cols.add("ten");
        cols.add("chuyen nganh");
        cols.add("so tin chi");
        // test
        

        // create && show list input
        createInput();
        repaint();
        // make modal
    }

    // input
    private void createInput() {
        // make config
        inputPanel = new JPanel();
        inputPanel.setSize(400, 300);
        inputPanel.setLayout(new GridLayout(4, 2));
        // Border 
        Border border = BorderFactory.createLineBorder(Color.BLACK);

        // add label + input
        nameLabel = new JLabel("TEN");
        nameTxt = new JTextArea(1, 20);
        nameTxt.setBorder(border);

        typeLabel = new JLabel("CHUYEN NGHANH");
        typeTxt = new JTextArea(1, 20);

        creditLabel = new JLabel("TIN CHI");
        creditTxt = new JTextArea(1, 20);

        //save btn
        saveButton = new JButton("SAVE");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(creditTxt.getText());
            }
        });
        
        // add to frame
        inputPanel.add(nameLabel);
        inputPanel.add(nameTxt);

        inputPanel.add(typeLabel);
        inputPanel.add(typeTxt);

        inputPanel.add(creditLabel);
        inputPanel.add(creditTxt);
        //save btn
        inputPanel.add(saveButton);
        // display 
        inputPanel.setVisible(true);

        // add to main Frame
        add(inputPanel);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new BookManager();
    }

}
