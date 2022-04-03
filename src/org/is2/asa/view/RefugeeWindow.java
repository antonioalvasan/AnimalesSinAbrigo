package org.is2.asa.view;

import org.is2.asa.control.Controller;
import org.is2.asa.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RefugeeWindow extends JFrame {
    private JPanel panel1;
    private JButton buttonConfig;
    private JButton annimalsButton;
    private Controller ctrl;

    public RefugeeWindow(Controller ctrl){
        super("ejemplo de java swing");
        this.ctrl=ctrl;
        setContentPane(panel1);

    }


}
