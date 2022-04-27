package org.is2.asa.view.Refuge;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class RefugeAddAnimalWindow extends windowClass {

    public static final String key = "RAAW";
    private RefugeController refugeCtrl;

    public RefugeAddAnimalWindow(RefugeController refugeCtrl){
        super(key);
        this.refugeCtrl = refugeCtrl;
    }

    private record Pair(JLabel label, JTextField textField) {

        public JLabel getLabel() {
            return label;
        }

        public JTextField getTextField() {
            return textField;
        }

    }

    public void prepare_panel() {

        this.setLayout(new BorderLayout());

        //CHANGE DATA panel
        JPanel changeDataPanel = new JPanel();
        changeDataPanel.setLayout(new BoxLayout(changeDataPanel, BoxLayout.Y_AXIS));

        JLabel modify = new JLabel("<html><body>Añadir datos animal<br> <body><html>");
        modify.setFont(new Font("Arial",Font.BOLD,30));
        modify.setHorizontalAlignment(JLabel.CENTER);
        modify.setBackground(Color.LIGHT_GRAY);
        modify.setOpaque(true);
        modify.setBorder(BorderFactory.createLineBorder(Color.black));

        Pair name = new Pair( new JLabel("Name"), new JTextField("Write the name..."));
        Pair age = new Pair( new JLabel("Age"), new JTextField("Write the age..."));
        Pair weight = new Pair( new JLabel("Weight"), new JTextField("Write the weight..."));
        Pair specie = new Pair( new JLabel("Specie"), new JTextField("Write the specie..."));
        Pair race = new Pair( new JLabel("Race"), new JTextField("Write the race..."));
        Pair description = new Pair( new JLabel("Description"), new JTextField("Write a description..."));

        ArrayList<Pair> data = new ArrayList<>(Arrays.asList(name, age, weight, description, specie, race));
        ArrayList<JPanel> panels = new ArrayList<>();

        for(int i =0; i < 6; i++) {
            panels.add(new JPanel(new FlowLayout()));
            panels.get(i).setBackground(Color.GRAY);
            panels.get(i).add(data.get(i).getLabel());
            panels.get(i).add(data.get(i).getTextField());
            changeDataPanel.add(panels.get(i));
        }

        //SAVE Button
        JButton save = new JButton("Save data");
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refugeCtrl.createAnimal(name.getTextField().getText(),
                        age.getTextField().getText(),
                        weight.getTextField().getText(),
                        specie.getTextField().getText(),
                        race.getTextField().getText(),
                        description.getTextField().getText()
                        );
                refugeCtrl.changeWindow(RefugeAnimalsWindow.key);
                refugeCtrl.run();
            }
        });
        save.setOpaque(true);
        save.setBackground(Color.LIGHT_GRAY);

        this.add(modify, BorderLayout.NORTH);
        this.add(changeDataPanel, BorderLayout.CENTER);
        this.add(save, BorderLayout.SOUTH);

    }
}
