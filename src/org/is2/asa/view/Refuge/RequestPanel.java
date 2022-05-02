package org.is2.asa.view.Refuge;

import org.is2.asa.control.RefugeController;
import org.is2.asa.model.Animal;
import org.is2.asa.view.Utilities;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestPanel extends JPanel{

    Animal animal;
    RefugeController refugeCtrl;

    public RequestPanel(Animal animal, RefugeController refugeCtrl) {
        this.animal = animal;
        this.refugeCtrl = refugeCtrl;
    }
    public void prepare_panel() {

        this.setBackground(Color.GRAY);
        this.setLayout(new FlowLayout());

        JButton dog_image = new JButton(new ImageIcon("perrillo.png"));
        this.add(dog_image, BorderLayout.EAST);

        Utilities.setTransparent(dog_image);

        JPanel panel_centre = new JPanel(new BorderLayout());

        Label dog_name = new Label(animal.getName());
        Label dog_description = new Label(animal.getDescription());
        dog_name.setBackground(Color.GRAY);
        dog_description.setBackground(Color.GRAY);


        panel_centre.add(dog_name, BorderLayout.NORTH);
        panel_centre.add(dog_description, BorderLayout.CENTER);

        this.add(panel_centre);



        JButton info = new JButton("info");


        info.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refugeCtrl.setAnimal(animal);
                ResquestRefugeSecundaryWindow dialogo3= new ResquestRefugeSecundaryWindow(refugeCtrl);
                dialogo3.prepare_panel();
                dialogo3.setSize(800,400);
                dialogo3.setLocationRelativeTo(null);
                dialogo3.setVisible(true);

            }

        });


        info.setBackground(Color.LIGHT_GRAY);

        this.add(info, FlowLayout.RIGHT);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setPreferredSize(new Dimension(600, 100));
    }


}
