/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai5;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author sonht
 */
public class FileChooser extends JFrame {

    private JFrame mainFrame;
    private JPanel mainPanel;
    private JFileChooser fileChooser;
    private JButton button;
    private JLabel label, status;

    public FileChooser() {
        mainFrame = new JFrame("File chooser");
        mainFrame.setSize(500, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        label = new JLabel("Choose a file", JLabel.CENTER);
        status = new JLabel("", JLabel.CENTER);

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        mainFrame.add(label);
        mainFrame.add(mainPanel);
        mainFrame.add(status);
        mainFrame.setVisible(true);
    }

    private void genFileChooser() {
        fileChooser = new JFileChooser();
        button = new JButton("Open");
        JPanel mainImagePanel = new JPanel();
        button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 int val = fileChooser.showOpenDialog(mainFrame);
                 if (val == 0) {
                     java.io.File file = fileChooser.getSelectedFile();
                     status.setText(file.getName());
                     BufferedImage image;
                     try {
                         image = ImageIO.read(new File(file.getPath()));
                         JPanel imagePanel = new JPanel() {
                             @Override
                             protected void paintComponent(Graphics g) {
                                 super.paintComponent(g);
                                 g.drawImage(image, 0, 0, 100, 100, null);
                             }
                         };
                         mainImagePanel.add(imagePanel);
                     } catch (IOException ex) {
                         ex.printStackTrace();
                     }
                 } else {
                     status.setText("No file is chosen !");
                 }
                 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             }
         }
        );
        mainPanel.add(button);
        mainPanel.add(mainImagePanel);
        mainPanel.setVisible(true);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        FileChooser chooser = new FileChooser();
        chooser.genFileChooser();
    }
}
