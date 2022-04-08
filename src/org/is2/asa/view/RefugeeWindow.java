package org.is2.asa.view;

import org.is2.asa.control.LoginController;

import javax.swing.*;

public class RefugeeWindow extends JFrame {
    private JPanel panel1;
    private JButton configuraciónButton;
    private JButton animalesButton;
    private LoginController ctrl;

    public RefugeeWindow(LoginController ctrl){
        super("ejemplo de java swing");
        this.ctrl=ctrl;
        setContentPane(panel1);

    }


}
