package bai6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CountNumber extends JFrame implements ActionListener {
    private JLabel label;
    private JButton checkButton, clearButton;
    private JTextArea input, output;
    private JPanel inputArea, outputArea;
    private JScrollPane outputScroll;

    public CountNumber(){
        createMainFrame();
        setSize(400, 300);
        checkButton.addActionListener(this);
        clearButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    private void createMainFrame(){
        inputArea = new JPanel();
        inputArea.setSize(400, 200);
        label = new JLabel("Nhap mot day so: ");
        inputArea.add(label);
        input = new JTextArea(1, 20);
        inputArea.add(input);
        inputArea.setVisible(true);
        add(inputArea);

        outputArea = new JPanel();
        checkButton = new JButton("Check");
        clearButton = new JButton("Clear");

        outputArea.add(checkButton);
        outputArea.add(clearButton);
        output = new JTextArea(10, 20);
        output.setEditable(false);
        outputScroll = new JScrollPane(output);
        outputArea.add(outputScroll);
        outputArea.setVisible(true);
        add(outputArea);
    }

    public static void main(String[] args) {
        new CountNumber();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("Check")){
            String inputString = input.getText();
            StringBuilder res = new StringBuilder("");

            ArrayList <Integer> arr, temp;
            Map <Integer, Integer> map = new HashMap<>();
            arr = mapToArr(new StringTokenizer(inputString));
            temp = new ArrayList<>();

            for(int i=0; i<arr.size(); i++){
                if(!map.containsKey(arr.get(i))){
                    map.put( arr.get(i), 1);
                    temp.add(arr.get(i));
                }
                else{
                    map.put( arr.get(i), map.get(arr.get(i)) + 1);
                }
            }

            for(int i=0; i<temp.size(); i++){
                res.append(temp.get(i) + " xuat hien " + map.get(temp.get(i)) + " lan.\n");
            }
            output.setText(res.toString());
        }
        else if(cmd.equals("Clear")){
            input.setText("");
            output.setText("");
        }
    }

    private ArrayList<Integer> mapToArr(StringTokenizer stringTokenizer){
        ArrayList <Integer> arr = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()){
            String token = stringTokenizer.nextToken();
            arr.add(Integer.parseInt(token));
        }
        return arr;
    }
}
