package org.is2.asa.view.Refuge;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.Utilities;
import org.is2.asa.view.adopter.views.AdopterHomeWindow;
import org.is2.asa.view.windowClass;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RefugeBar extends windowClass {

    public final static String key = "RB";
    public RefugeController refugeCtrl;

    public RefugeBar(RefugeController ctrl) {
        super(key);
        refugeCtrl = ctrl;

    }
    public void prepare_panel(){

        this.setLayout(new BorderLayout());

        JButton home = new JButton("Home");
        JButton animals = new JButton("Animals");
        JButton requests = new JButton("Requests");
        requests.addActionListener(e->{
            refugeCtrl.changeWindow(RefugeRequestWindow.key);
            refugeCtrl.run();
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
