package org.is2.asa.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AnimalListWindow extends JPanel {
    public void prepare_window() {
        this.setLayout(new BorderLayout());

        JLabel modify = new JLabel("modificar datos");
        JButton save = new JButton("save");
        JLabel name = new JLabel("name");
        JLabel password = new JLabel("contraseña");
        JLabel province = new JLabel("provincia");
        JLabel address = new JLabel("dirección");
        JLabel phoneNumber = new JLabel("número de teléfono");
        JLabel description = new JLabel("descripción");



        JTextField usernameT = new JTextField("Write your new username here...");
        JTextField passwordT = new JTextField("Write your new password here...");
        JTextField nameT = new JTextField("Write your new name here...");
        JTextField provinceT = new JTextField("Write your new province here...");
        JTextField addressT = new JTextField("Write your new address here...");
        JTextField tlfT = new JTextField("Write your new phone number here...");

        ArrayList<JPanel> panel_list = new ArrayList<JPanel>();

        for(int i =0; i < 6; i++)
            panel_list.add(new JPanel(new FlowLayout()));

        panel_list.get(0).add(name);
        panel_list.get(0).add(nameT);

    }

}
