package org.is2.asa.view.Refuge;

import org.is2.asa.view.Utilities;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestPanel extends JPanel{
    public RequestPanel( ) {


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
                "Request data ");
        dog_name.setBackground(Color.GRAY);
        dog_description.setBackground(Color.GRAY);


        panel_centre.add(dog_name, BorderLayout.NORTH);
        panel_centre.add(dog_description, BorderLayout.CENTER);

        this.add(panel_centre);



        JButton info = new JButton("info");

        ResquestRefugeSecundaryWindow dialogo3= new ResquestRefugeSecundaryWindow();
        dialogo3.prepare_panel();
        dialogo3.setSize(500,300);
        dialogo3.setLocationRelativeTo(null);
        info.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dialogo3.setVisible(true);

            }

        });


        info.setBackground(Color.LIGHT_GRAY);

        this.add(info, FlowLayout.RIGHT);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setPreferredSize(new Dimension(600, 100));
    }


}
