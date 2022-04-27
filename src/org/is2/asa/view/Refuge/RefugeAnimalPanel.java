package org.is2.asa.view.Refuge;

import org.is2.asa.control.RefugeController;
import org.is2.asa.model.Animal;
import org.is2.asa.view.Utilities;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class RefugeAnimalPanel extends JPanel {

    RefugeController refugeCtrl;
    Animal animal;

    public RefugeAnimalPanel(Animal animal, RefugeController refugeCtrl) {
        this.refugeCtrl = refugeCtrl;
        this.animal = animal;
    }

    private record Pair(JLabel first, JLabel second) {

        public JLabel getFirst() {
            return first;
        }

        public JLabel getSecond() {
            return second;
        }

    }

    public void prepare_panel() {

        this.setBackground(Color.GRAY);
        this.setLayout(new FlowLayout());

        JButton animalImg = new JButton(new ImageIcon(animal.getImg()));
        this.add(animalImg, BorderLayout.EAST);

        Utilities.setTransparent(animalImg);

        JPanel panel_centre = new JPanel(new BorderLayout());

        Label animalName = new Label(animal.getName());
        Label animalDesc = new Label(animal.getDescription());
        animalName.setBackground(Color.GRAY);
        animalDesc.setBackground(Color.GRAY);


        panel_centre.add(animalName, BorderLayout.NORTH);
        panel_centre.add(animalDesc, BorderLayout.CENTER);

        this.add(panel_centre);

        JButton infoButton = new JButton("Info");
        infoButton.setBackground(Color.LIGHT_GRAY);

        infoButton.addActionListener(e->{
            JDialog infoDialog = new JDialog();
            JPanel infoPanel = new JPanel(new BorderLayout());

            Pair namePair = new Pair( new JLabel("Name:"), new JLabel(animal.getName()));
            Pair agePair = new Pair( new JLabel("Age:"), new JLabel(String.valueOf(animal.getAge())));
            Pair weightPair = new Pair( new JLabel("Weight:"), new JLabel(String.valueOf(animal.getWeight())));
            Pair speciePair = new Pair( new JLabel("Specie:"), new JLabel(animal.getSpecies()));
            Pair racePair = new Pair( new JLabel("Race:"), new JLabel(animal.getRace()));

            ArrayList<Pair> data = new ArrayList<>(Arrays.asList(namePair, agePair, weightPair, speciePair, racePair));
            ArrayList<JPanel> panels = new ArrayList<>();

            for(int i = 0; i<data.size(); i++){
                panels.add(new JPanel(new FlowLayout()));
                panels.get(i).setBackground(Color.GRAY);
                data.get(i).getFirst().setFont(new Font("Arial", Font.BOLD, 25));
                data.get(i).getSecond().setFont(new Font("Arial", Font.BOLD, 25));
                panels.get(i).add(data.get(i).getFirst());
                panels.get(i).add(data.get(i).getSecond());
                infoPanel.add(panels.get(i));
            }

            infoDialog.setSize(new Dimension(500, 500));
            infoDialog.add(infoPanel);
            infoDialog.setVisible(true);
        });


        this.add(infoButton, FlowLayout.RIGHT);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setPreferredSize(new Dimension(600, 100));

    }
}
