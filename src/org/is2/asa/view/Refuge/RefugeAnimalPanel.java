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

//MVC design pattern used
public class RefugeAnimalPanel extends JPanel {

    RefugeController refugeCtrl;
    Animal animal;

    public RefugeAnimalPanel(Animal animal, RefugeController refugeCtrl) {
        this.refugeCtrl = refugeCtrl;
        this.animal = animal;
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
        JLabel animalState = new JLabel(animal.getState().toString());
        animalState.setBackground(Color.GRAY);
        animalName.setBackground(Color.GRAY);
        animalDesc.setBackground(Color.GRAY);
        panel_centre.setBackground(Color.GRAY);

        panel_centre.add(animalName, BorderLayout.NORTH);
        panel_centre.add(animalDesc, BorderLayout.CENTER);
        panel_centre.add(animalState, BorderLayout.SOUTH);

        this.add(panel_centre);

        JButton infoButton = new JButton("Info");
        infoButton.setBackground(Color.LIGHT_GRAY);

        infoButton.addActionListener(e->{
            refugeCtrl.setAnimal(animal);
            refugeCtrl.changeWindow(InfoAnimalRefuge.key);
            refugeCtrl.run();
        });


        this.add(infoButton, FlowLayout.RIGHT);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setPreferredSize(new Dimension(600, 270));

    }
}
