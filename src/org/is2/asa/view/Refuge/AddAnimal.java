package org.is2.asa.view.Refuge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class AddAnimal extends JDialog {
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

        JLabel modify = new JLabel("<html><body>Añadir datos animal<br> <body><html>");
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


        Pair identifier = new Pair( new JLabel("Identifier"), new JTextField("Write the identifier..."));
        Pair link = new Pair( new JLabel("LinkedUser"), new JTextField("Write the LinkedUser ..."));
        Pair name = new Pair( new JLabel("Name"), new JTextField("Write the name..."));
        Pair age = new Pair( new JLabel("Age"), new JTextField("Write the age..."));
        Pair weight = new Pair( new JLabel("Weight"), new JTextField("Write the weight..."));
        Pair description = new Pair( new JLabel("Description"), new JTextField("Write a description..."));
        Pair specie = new Pair( new JLabel("Weight"), new JTextField("Write the specie..."));
        Pair race = new Pair( new JLabel("Description"), new JTextField("Write the race..."));
        ArrayList<Pair> data = new ArrayList<>(Arrays.asList(identifier, link, name, age, weight, description,specie,race));
        ArrayList<JPanel> panels = new ArrayList<>();

        for(int i =0; i < 8; i++) {
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
