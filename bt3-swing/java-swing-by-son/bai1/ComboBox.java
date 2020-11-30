package bai1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author sonht
 */
public class ComboBox {

    private JFrame boxFrame;
    private JComboBox combobox;
    private JButton button;
    private JLabel label;
    private JLabel bottomLabel;


    public ComboBox() {
        boxFrame = new JFrame("Color choices");
        boxFrame.setSize(400, 400);
        boxFrame.setDefaultCloseOperation(boxFrame.EXIT_ON_CLOSE);
        boxFrame.setLayout(new FlowLayout());

        String colors[] = {"#ff7f00","#ffffff","#845EC2", "#D65DB1", "#FF6F91", "#0081CF", "#FFC75F", "#008F7A"};

        boxFrame.getContentPane().setBackground(Color.decode(colors[0]));
        label = new JLabel("Colors : ", JLabel.CENTER);
        label.setBounds(50, 50, 80, 20);
        boxFrame.add(label);

        combobox = new JComboBox(colors);
        combobox.setBounds(100, 50, 150, 20);
        boxFrame.add(combobox);

        bottomLabel = new JLabel("", JLabel.CENTER);
        bottomLabel.setSize(400, 100);

        combobox.addItemListener((e) -> {
            String data = colors[0];
            if(combobox.getSelectedIndex() != -1){
                data = "" + combobox.getItemAt(combobox.getSelectedIndex());
            }
//                if (e.getStateChange() == ItemEvent.SELECTED)
//                    data = (String) e.getItem();
            bottomLabel.setText(data);
            boxFrame.getContentPane().setBackground(Color.decode(data));
        });

//        boxFrame.add(button);
        boxFrame.add(bottomLabel);
        boxFrame.setLocationRelativeTo(null);
        boxFrame.setVisible(true);

    }

    public static void main(String[] args) {
        new ComboBox();
    }

}
