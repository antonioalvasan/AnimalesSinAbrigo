package org.is2.asa.view;

import org.is2.asa.control.AdopterController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class AdopterUserInfoWindow extends windowClass {

    public static final String keyCode = "AUIW1";
    AdopterController adopterController;


    public AdopterUserInfoWindow(AdopterController adopterController) {
        super(keyCode);
        this.adopterController = adopterController;
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

        AdopterBar bar = new AdopterBar(this.adopterController);
        bar.prepare_panel();

        JButton modify = new JButton("Change your data here");
        modify.setBackground(Color.LIGHT_GRAY);
        modify.addActionListener(e -> {
            adopterController.changeWindow( AdopterUserInfoWindow2.keyCode);
            adopterController.run();
        });

        JPanel center = new JPanel(new BorderLayout());
        center.setBackground(Color.gray);

        JButton user_image = new JButton(new ImageIcon("imagen.png"));
        Utilities.setTransparent(user_image);

        center.add(user_image, BorderLayout.WEST);

        Pair username = new Pair( new JLabel("Username:"), new JLabel(adopterController.getUsername()));
        Pair password = new Pair( new JLabel("Password:"),new JLabel(adopterController.getPassword()));
        Pair name = new Pair( new JLabel("Name:"),new JLabel(adopterController.getName()));
        Pair province = new Pair( new JLabel("Province:"), new JLabel(adopterController.getProvince()));
        Pair address = new Pair( new JLabel("Address:"), new JLabel(adopterController.getAddress()));
        Pair tlf = new Pair( new JLabel("Phone number:"), new JLabel(adopterController.getTlf()));

        ArrayList<Pair> data = new ArrayList<>(Arrays.asList(username, password, name, province, address, tlf));
        ArrayList<JPanel> panels = new ArrayList<>();
        JPanel leftP = new JPanel();
        leftP.setLayout(new BoxLayout(leftP, BoxLayout.Y_AXIS));

        for(int i =0; i < 6; i++) {
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
