/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author hp
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.User;
import control.SimpleClientCtr;

public class SimpleLoginFrm extends JFrame implements ActionListener {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private SimpleClientCtr mySocket;

    public SimpleLoginFrm(SimpleClientCtr socket) {
        super("TCP Login MVC");
        mySocket = socket;

        txtUsername = new JTextField(15);
        txtPassword = new JPasswordField(15);
        txtPassword.setEchoChar('*');
        btnLogin = new JButton("Login");

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Username:"));
        content.add(txtUsername);
        content.add(new JLabel("Password:"));
        content.add(txtPassword);
        content.add(btnLogin);
        btnLogin.addActionListener(this);

        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() instanceof JButton) && (((JButton) e.getSource()).equals(btnLogin))) {
            //pack the entity
            User user = new User();
            user.setUsername(txtUsername.getText());
            user.setPassword(txtPassword.getText());

            //sending data
            mySocket.sendData(user);

            //receive data
            Object obj = mySocket.receiveData();
            if (obj instanceof String) {
                String result = (String) obj;
                if (result.equals("ok")) {
                    JOptionPane.showMessageDialog(this, "Login succesfully!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect username and/or password!");
                }
            }
        }
    }
}
