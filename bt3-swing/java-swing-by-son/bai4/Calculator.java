/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author sonht
 */
public class Calculator extends JFrame {

    private JButton btn;
    private JTextArea textArea1, textArea2;
    private JPanel btnPanel, outputPanel, mainFrame;
    private double a = 0, b = 0;
    private String op = "";
    private double res = 0;
    private String textAreaValue;

    public Calculator() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(240, 350);
        this.setLocationRelativeTo(null);
        this.add(genMainFrame());
        this.setVisible(true);
    }

    String btns[] = {"AC", "sqrt", "del", "+", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "^", ".", "="};

    private JButton genBtn(String label) {
        btn = new JButton(label);
        btn.setBackground(Color.white);
        btn.setForeground(Color.red);
        btn.addActionListener((e) -> {
            String value = e.getActionCommand();
            if (value == "AC") {
                textArea1.setText("");
                textArea2.setText("");
                a = 0; b = 0;
            }
            if (value == "sqrt" || value == "^" || value == "0" || value == "1" || value == "2" || value == "3" || value == "4" || value == "5" || value == "6" || value == "7" || value == "8" || value == "9") {
                textAreaValue = textArea1.getText();
                if(textAreaValue.indexOf("+") != -1 || textAreaValue.indexOf("-") != -1 || textAreaValue.indexOf("*") != -1 || textAreaValue.indexOf("/") != -1){
                    textArea1.setText("");
                }
                if(value == "sqrt" || value == "^"){
                    if(a == 0){
                        op = "single";
                    }
                }
                textArea1.append(value);
            }
            if (value == "del") {
                textAreaValue = textArea1.getText();
                textArea1.setText(textAreaValue.substring(0, textAreaValue.length() - 1));
            }
            if (value == "+" || value == "-" || value == "*" || value == "/") {
                op = value;
                textAreaValue = textArea1.getText();
                if (textAreaValue == "") {
                    a = 0;
                }
                else if (textAreaValue.indexOf("sqrt") != -1) {
                    a = Math.sqrt(Double.parseDouble(textAreaValue.substring(4)));
                }
                else if (textAreaValue.indexOf("^") != -1) {
                    int index = textAreaValue.indexOf("^");
                    double s1 = Double.parseDouble(textAreaValue.substring(0, index));
                    double s2 = Double.parseDouble(textAreaValue.substring(index+1));
                    b = Math.pow(s1, s2);
                }
                else a = Double.parseDouble(textAreaValue);
                textArea1.setText(value);
            }
            if (value == "=") {
                textAreaValue = textArea1.getText();
                if (textAreaValue.indexOf("sqrt") != -1) {
                    b = Math.sqrt(Double.parseDouble(textAreaValue.substring(4)));
                }
                else if (textAreaValue.indexOf("^") != -1) {
                    int index = textAreaValue.indexOf("^");
                    System.out.println(index);
                    double s1 = Double.parseDouble(textAreaValue.substring(0, index));
                    double s2 = Double.parseDouble(textAreaValue.substring(index+1));
                    b = Math.pow(s1, s2);
                }
                else b = Double.parseDouble(textAreaValue);
                switch (op) {
                    case "single":
                        res = b;
                        break;
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "*":
                        res = a * b;
                        break;
                    case "/":
                        res = a / b;
                        break;
                    default:
                        res = Double.parseDouble(textAreaValue);
                }
                textArea2.setText(new Double(res).toString());
                textArea1.setText("");
            }
        });
        return btn;
    }

    private JPanel mapBtn() {
        btnPanel = new JPanel(new GridLayout(5, 4));
        for (int i = 0; i < btns.length; i++) {
            btnPanel.add(genBtn(btns[i]));
        }
        btnPanel.setBackground(Color.white);
        return btnPanel;
    }

    private JPanel genOutputPanel() {
        outputPanel = new JPanel(new GridLayout(2, 1));

        textArea1 = new JTextArea(2, 1);
        textArea1.setBackground(Color.white);
        outputPanel.add(textArea1);
        textArea1.setEditable(false);

        textArea2 = new JTextArea(2, 1);
        textArea2.setBackground(Color.white);
        outputPanel.add(textArea2);
        textArea2.setEditable(false);

        return outputPanel;
    }

    private JPanel genMainFrame() {
        this.setTitle("Calculator");
        mainFrame = new JPanel(new BorderLayout(4, 5));
        mainFrame.add(genOutputPanel(), BorderLayout.NORTH);
        mainFrame.add(mapBtn(), BorderLayout.CENTER);
        mainFrame.setBackground(Color.white);
        return mainFrame;
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
