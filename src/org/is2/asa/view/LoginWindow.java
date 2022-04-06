package org.is2.asa.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JPanel {

    public LoginWindow(){};

    public void prepareWindow(){

        this.setLayout(new BorderLayout());

        JPanel centreLayout = new JPanel();
        centreLayout.setLayout(new BoxLayout(centreLayout, BoxLayout.Y_AXIS));

        JTextField usernameField = new JTextField("Username");
        JPasswordField passwordField = new JPasswordField("Password");

        JButton loginButton = new JButton("Login");
        this.add(loginButton, BorderLayout.PAGE_END);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
            }
        });

        centreLayout.add(usernameField);
        centreLayout.add(passwordField);

        this.add(centreLayout, BorderLayout.CENTER);


    }

}
