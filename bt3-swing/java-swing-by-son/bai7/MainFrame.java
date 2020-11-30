package bai7;

import bai7.sort.SortByCredits;
import bai7.sort.SortById;
import bai7.sort.SortByName;
import bai7.sort.SortByType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class MainFrame extends JFrame {

    private JLabel creditLabel, nameLabel, typeLabel, comboBoxLabel;
    private JButton saveButton, showButton;
    private JTable outputTable;
    private JPanel inputPanel, controlPanel;
    private JTextArea nameTxt, typeTxt, creditTxt;
    private JComboBox comboBox;
    private DefaultTableModel model;

    public MainFrame() throws FileNotFoundException {
        Vector<String> cols = new Vector<>();
        cols.add("ID");
        cols.add("Ten MH");
        cols.add("Chuyen nganh");
        cols.add("So tin chi");

        model = new DefaultTableModel(cols, 0);
        createInputFrame();
        createControlFrame();
        createOutputTable(getSubjects("src/bai7/file/MH.INP.txt"));
        System.out.println(getSubjects("src/bai7/file/MH.INP.txt"));
        setSize(800, 500);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createInputFrame(){

        // init JFrame
        inputPanel = new JPanel();
        inputPanel.setSize(400, 300);
        inputPanel.setLayout(new GridLayout(4, 2));
        nameLabel = new JLabel("Ten mon hoc : ");
        nameTxt = new JTextArea(1, 20);
        typeLabel = new JLabel("Chuyen nganh : ");
        typeTxt = new JTextArea(1, 20);
        creditLabel = new JLabel("So tin chi : ");
        creditTxt = new JTextArea(1, 20);
        saveButton = new JButton("Save");
//        showButton = new JButton("Show");

        // add action
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTxt.getText();
                String type = typeTxt.getText();
                String credits = creditTxt.getText();
                try {
                    ArrayList <Subject> subjects = getSubjects("src/bai7/file/MH.INP.txt");
                    if(!name.equals("") && !type.equals("") && !credits.equals("")){
                        subjects.add(new Subject(subjects.size()+1000, name, type, Integer.parseInt(credits)));
//                        model.setRowCount(0);
//                        for(Subject subject : subjects){
//                            model.addRow(subject.toVector(subject));
//                        }
                        nameTxt.setText("");
                        typeTxt.setText("");
                        creditTxt.setText("");
                        writeToFile(subjects, "src/bai7/file/MH.INP.txt");
                        comboBox.setSelectedIndex(0);
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        // add action
//        showButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    ArrayList <Subject> subjects = getSubjects("src/bai7/file/MH.INP.txt");
//                    model.setRowCount(0);
//                    for(Subject subject : subjects){
//                        model.addRow(subject.toVector(subject));
//                    }
//                } catch (FileNotFoundException fileNotFoundException) {
//                    fileNotFoundException.printStackTrace();
//                }
//            }
//        });

        inputPanel.add(nameLabel);
        inputPanel.add(nameTxt);
        inputPanel.add(typeLabel);
        inputPanel.add(typeTxt);
        inputPanel.add(creditLabel);
        inputPanel.add(creditTxt);
        inputPanel.add(saveButton);
//        inputPanel.add(showButton);

        inputPanel.setVisible(true);
        add(inputPanel);

    }

    private void createControlFrame(){
        controlPanel = new JPanel();
        controlPanel.setSize(500, 400);

        String comboBoxVals[] = {"Khong", "ID", "Ten", "Chuyen nganh", "So tin chi"};
        comboBox = new JComboBox(comboBoxVals);
        comboBoxLabel = new JLabel("Sap xep theo : ");

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList <Subject> subjects = null, tempSubjects = null;
                String val = String.valueOf(comboBox.getSelectedItem());
                try {
                    subjects = getSubjects("src/bai7/file/MH.INP.txt");
                    tempSubjects = subjects;
                    if(val.equals("Khong")){
                        tempSubjects = subjects;
                    }
                    else if(val.equals("ID")){
                        Collections.sort(tempSubjects, new SortById());
                    }
                    else if(val.equals("Ten")){
                        Collections.sort(tempSubjects, new SortByName());
                    }
                    else if(val.equals("Chuyen nganh")){
                        Collections.sort(tempSubjects, new SortByType());
                    }
                    else {
                        Collections.sort(tempSubjects, new SortByCredits());
                    }
                    model.setRowCount(0);
                    for(Subject subject : tempSubjects){
                        model.addRow(subject.toVector(subject));
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });

        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(comboBoxLabel);
        controlPanel.add(comboBox);
        controlPanel.setVisible(true);
        add(controlPanel);
    }

    private void createOutputTable(ArrayList<Subject> subjects){

        for(Subject subject : subjects){
            model.addRow(subject.toVector(subject));
        }

        outputTable = new JTable(model);
        JScrollPane scrollTable = new JScrollPane(outputTable);
        controlPanel.add(scrollTable);
        controlPanel.setVisible(true);
    }

    private ArrayList<Subject> getSubjects (String path) throws FileNotFoundException {
        ArrayList<Subject> subjects = new ArrayList<>();
        Scanner scanner = new Scanner(new File(path), "utf-8");
        while(scanner.hasNextLine()) {
            int id = Integer.parseInt(scanner.nextLine());
            String name = scanner.nextLine();
            String type = scanner.nextLine();
            int credits = Integer.parseInt(scanner.nextLine());
            if(id >= 1000 && id <= 9999){
                if(!name.equals("")){
                    if(!type.equals("")){
                        if(credits > 0 && credits < 7){
                            subjects.add(new Subject(id, name, type, credits));
                        }
                    }
                }
            }
        }
        return subjects;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new MainFrame();
    }

    private void writeToFile(ArrayList<Subject> subjects, String path) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(path));
        PrintWriter printWriter = new PrintWriter(fos);
        for(Subject subject : subjects){
            printWriter.println(subject.getId());
            printWriter.println(subject.getName());
            printWriter.println(subject.getType());
            printWriter.println(subject.getCredits());
        }
        printWriter.close();
        fos.close();
    }

}
