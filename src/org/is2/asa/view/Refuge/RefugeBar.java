package org.is2.asa.view.Refuge;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.Utilities;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RefugeBar extends JPanel{
   public RefugeController controladorventanas;
    public RefugeBar(RefugeController ctrl) {
    controladorventanas= ctrl;

    }
    public void prepare_panel(){

        this.setLayout(new BorderLayout());

        JButton home = new JButton("Home");
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controladorventanas.mostrar("Home");
            }

        });
        JButton animals = new JButton("Animals");
        animals.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controladorventanas.mostrar("animals");
            }

        });





        JButton requests = new JButton("Requests");
        requests.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controladorventanas.mostrar("request");
            }

        });
        JButton contact = new JButton("Contact");

        JPanel left = new JPanel(new FlowLayout());
        left.setBackground(Color.LIGHT_GRAY);

        left.add(home);
        left.add(animals);
        left.add(requests);
        left.add(contact);

        Utilities.setTransparent(home);
        Utilities.setTransparent(animals);
        Utilities.setTransparent(requests);
        Utilities.setTransparent(contact);

        JPanel right = new JPanel(new FlowLayout());
        right.setBackground(Color.LIGHT_GRAY);

        JButton user_name = new JButton("Refugio 1");
        user_name.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controladorventanas.mostrar("info");
            }

        });
        JButton user_icon = new JButton(new ImageIcon("imagen.png"));

        Utilities.setTransparent(user_name);
        Utilities.setTransparent(user_icon);

        right.add(user_name);
        right.add(user_icon);

        this.add(left, BorderLayout.WEST);
        this.add(right, BorderLayout.EAST);
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createLineBorder(Color.black));

    }


}
