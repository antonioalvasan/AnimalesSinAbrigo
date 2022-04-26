package org.is2.asa.view.Refuge;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.Utilities;
import org.is2.asa.view.windowClass;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class RefugeInfoWindow extends windowClass {

    public final static String key = "RIW";
    private static RefugeController refugeCtrl;

    public RefugeInfoWindow(RefugeController ctrl){
        super(key);
        refugeCtrl = ctrl;

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

        this.setLayout(new BorderLayout());

        RefugeBar bar = new RefugeBar(refugeCtrl);
        bar.prepare_panel();

        JButton modify = new JButton("Change your data here");
        RefugeModifyWindow info= new RefugeModifyWindow(refugeCtrl);
        info.prepare_panel();
        info.setSize(500,400);
        //fo.setLocationRelativeTo(null);
        modify.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                info.setVisible(true);
            }

        });



        modify.setBackground(Color.LIGHT_GRAY);
        modify.addActionListener(e -> {

        });

        JPanel center = new JPanel(new BorderLayout());
        center.setBackground(Color.gray);

        JButton user_image = new JButton(new ImageIcon("imagen.png"));
        Utilities.setTransparent(user_image);

        center.add(user_image, BorderLayout.WEST);

        Pair username = new Pair( new JLabel("Username:"), new JLabel("gilleGamer"));
        Pair password = new Pair( new JLabel("Password:"),new JLabel("1234"));
        Pair name = new Pair( new JLabel("Name:"),new JLabel("a"));
        Pair province = new Pair( new JLabel("Province:"), new JLabel("Valladolid"));
        Pair address = new Pair( new JLabel("Address:"), new JLabel("Av. Mundial 82, s/n, 47014 Valladolid"));
        Pair tlf = new Pair( new JLabel("Phone number:"), new JLabel("633 33 33 33"));
        Pair description = new Pair( new JLabel("Description:"), new JLabel("....."));
        ArrayList<Pair> data = new ArrayList<>(Arrays.asList(username, password, name, province, address, tlf,description));
        ArrayList<JPanel> panels = new ArrayList<>();
        JPanel leftP = new JPanel();
        leftP.setLayout(new BoxLayout(leftP, BoxLayout.Y_AXIS));

        for(int i =0; i < 7; i++) {
            panels.add(new JPanel(new FlowLayout()));
            panels.get(i).setBackground(Color.GRAY);
            data.get(i).getFirst().setFont(new Font("Arial", Font.BOLD, 25));
            data.get(i).getSecond().setFont(new Font("Arial", Font.BOLD, 25));
            panels.get(i).add(data.get(i).getFirst());
            panels.get(i).add(data.get(i).getSecond());
            leftP.add(panels.get(i));
        }

        leftP.setAlignmentY(JPanel.CENTER_ALIGNMENT);
        center.setAlignmentY(JPanel.CENTER_ALIGNMENT);
        center.add(leftP, BorderLayout.CENTER);


        this.add(bar, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(modify, BorderLayout.SOUTH);
    }

}




