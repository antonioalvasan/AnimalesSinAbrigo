package org.is2.asa.view.Refuge;

import org.is2.asa.control.AnimalController;
import org.is2.asa.view.Utilities;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalPanel extends JPanel {


    AnimalController animalController;
    public AnimalPanel(AnimalController animalController) {
        this.animalController = animalController;

    }


    public void prepare_panel(String name) {

        this.setBackground(Color.GRAY);
        this.setLayout(new FlowLayout());

        JButton dog_image = new JButton(new ImageIcon("perrillo.png"));
        this.add(dog_image, BorderLayout.EAST);

        Utilities.setTransparent(dog_image);

        JPanel panel_centre = new JPanel(new BorderLayout());

        Label dog_name = new Label(name);
        Label dog_description = new Label(
                "Nombre y descripcción ");
        dog_name.setBackground(Color.GRAY);
        dog_description.setBackground(Color.GRAY);


        panel_centre.add(dog_name, BorderLayout.NORTH);
        panel_centre.add(dog_description, BorderLayout.CENTER);

        this.add(panel_centre);



        JButton info = new JButton("info");
        InfoAnimalRefuge info2= new InfoAnimalRefuge(animalController);
        info2.prepare_panel();
        info2.setVisible(true);
        JDialog dialogo= new JDialog();
        dialogo.add(info2);
        dialogo.setSize(500,400);
        dialogo.setLocationRelativeTo(null);

        info.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dialogo.setVisible(true);

            }

        });


        info.setBackground(Color.LIGHT_GRAY);

        this.add(info, FlowLayout.RIGHT);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setPreferredSize(new Dimension(600, 100));
    }

    public AnimalPanel(LayoutManager layout) {
        super(layout);
        // TODO Auto-generated constructor stub
    }

    public AnimalPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        // TODO Auto-generated constructor stub
    }

    public AnimalPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        // TODO Auto-generated constructor stub
    }

}
