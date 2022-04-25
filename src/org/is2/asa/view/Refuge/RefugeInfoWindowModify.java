package org.is2.asa.view.Refuge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class RefugeInfoWindowModify extends JDialog {
    private static class Pair {

        private JLabel label;
        private JTextField button;

        public Pair(JLabel label, JTextField button) {
            this.label = label;
            this.button = button;
        }

        public JLabel getLabel() {
            return label;
        }

        public JTextField getButton() {
            return button;
        }

    }


    public void prepare_panel() {
        this.setLayout(new BorderLayout());

        JPanel change_data_here = new JPanel();
        change_data_here.setLayout(new BoxLayout(change_data_here, BoxLayout.Y_AXIS));

        JLabel modify = new JLabel("<html><body>Modificar datos<br> <body><html>");
        modify.setFont(new Font("Arial",Font.BOLD,30));
        modify.setHorizontalAlignment(JLabel.CENTER);
        modify.setBackground(Color.LIGHT_GRAY);
        modify.setOpaque(true);
        modify.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton save = new JButton("Save data");
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ocultar();

            }



        });
        save.setOpaque(true);
        save.setBackground(Color.LIGHT_GRAY);


       Pair username = new Pair( new JLabel("Username:"), new JTextField("gilleGamer"));
       Pair password = new Pair( new JLabel("Password:"),new JTextField("1234"));
        Pair name = new Pair( new JLabel("Name:"),new JTextField("a"));
        Pair province = new Pair( new JLabel("Province:"), new JTextField("Valladolid"));
        Pair address = new Pair( new JLabel("Address:"), new JTextField("Av. Mundial 82, s/n, 47014 Valladolid"));
        Pair tlf = new Pair( new JLabel("Phone number:"), new JTextField("633 33 33 33"));
        Pair description = new Pair( new JLabel("Description:"), new JTextField("....."));
        ArrayList<Pair> data = new ArrayList<>(Arrays.asList(username, password, name, province, address, tlf,description));
        ArrayList<JPanel> panels = new ArrayList<>();

        for(int i =0; i < 7; i++) {
            panels.add(new JPanel(new FlowLayout()));
            panels.get(i).setBackground(Color.GRAY);
            panels.get(i).add(data.get(i).getLabel());
            panels.get(i).add(data.get(i).getButton());
            change_data_here.add(panels.get(i));
        }

        this.add(modify, BorderLayout.NORTH);
        this.add(change_data_here, BorderLayout.CENTER);
        this.add(save, BorderLayout.SOUTH);

    }
    private void ocultar() {
        this.setVisible(false);
    }

}
