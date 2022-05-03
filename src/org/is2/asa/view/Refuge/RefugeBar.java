package org.is2.asa.view.Refuge;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.Utilities;
import org.is2.asa.view.adopter.views.AdopterHomeWindow;
import org.is2.asa.view.adopter.views.AdopterUserInfoWindow;
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

        home.addActionListener(e->{
            refugeCtrl.changeWindow(RefugeHomeWindow.key);
            refugeCtrl.run();
        });

        JButton animals = new JButton("Animals");

        animals.addActionListener(e->{
            refugeCtrl.changeWindow(RefugeAnimalsWindow.key);
            refugeCtrl.run();
        });

        JButton requests = new JButton("Requests");

        requests.addActionListener(e->{
            refugeCtrl.changeWindow(RefugeRequestWindow.key);
            refugeCtrl.run();
        });



        JPanel left = new JPanel(new FlowLayout());
        left.setBackground(new Color(197, 237, 253, 207));

        left.add(home);
        left.add(animals);
        left.add(requests);


        Utilities.setTransparent(home);
        Utilities.setTransparent(animals);
        Utilities.setTransparent(requests);


        JPanel right = new JPanel(new FlowLayout());
        right.setBackground(new Color(197, 237, 253, 207));

        JButton user_name = new JButton(refugeCtrl.getUsername());
        JButton user_icon = new JButton(new ImageIcon("resources/images/userIcon.png"));

        user_name.addActionListener(e ->{
            refugeCtrl.changeWindow(RefugeInfoWindow.key);
            refugeCtrl.run();
        });
        user_icon.addActionListener(e ->{
            refugeCtrl.changeWindow(RefugeInfoWindow.key);
            refugeCtrl.run();
        });

        Utilities.setTransparent(user_name);
        Utilities.setTransparent(user_icon);

        right.add(user_name);
        right.add(user_icon);

        this.add(left, BorderLayout.WEST);
        this.add(right, BorderLayout.EAST);
        this.setBackground(new Color(197, 237, 253, 207));
        this.setBorder(BorderFactory.createLineBorder(Color.black));

    }


}
