package org.is2.asa.view.Refuge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ModifyInfoAnimalRefuge extends JDialog {
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


    Pair username = new Pair( new JLabel("Identifier"), new JTextField("Write your new identifier here..."));
      Pair password = new Pair( new JLabel("LinkedUser"), new JTextField("Write your new LinkedUser here..."));
        Pair name = new Pair( new JLabel("Name"), new JTextField("Write your new name here..."));
       Pair province = new Pair( new JLabel("Age"), new JTextField("Write your new age here..."));
        Pair address = new Pair( new JLabel("Weight"), new JTextField("Write your new weight here..."));
       Pair tlf = new Pair( new JLabel("Description"), new JTextField("Write your new description here..."));

        ArrayList<Pair> data = new ArrayList<>(Arrays.asList(username, password, name, province, address, tlf));
        ArrayList<JPanel> panels = new ArrayList<>();

        for(int i =0; i < 6; i++) {
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
