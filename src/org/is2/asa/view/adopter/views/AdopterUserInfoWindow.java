package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.Utilities;
import org.is2.asa.view.windowClass;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class AdopterUserInfoWindow extends windowClass {

    public static final String keyCode = "AUIW";
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

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.setBackground(Color.LIGHT_GRAY);

        JButton modify = new JButton("Modify Data");
        modify.addActionListener(e -> {
            adopterController.changeWindow( AdopterUserInfoWindow2.key);
            adopterController.run();
        });

        JButton deleteButton = new JButton("Delete User");

        deleteButton.addActionListener(e -> {
            Dialog deleteDialog = new JDialog();

            JPanel mainPanel = new JPanel(new BorderLayout());

            JLabel messageLabel = new JLabel("Are you sure you want to delete this user?");

            JPanel buttons = new JPanel(new FlowLayout());

            JButton yesButton = new JButton("Yes");
            JButton noButton = new JButton("No");

            buttons.add(yesButton);
            buttons.add(noButton);

            mainPanel.add(messageLabel, BorderLayout.CENTER);
            mainPanel.add(buttons, BorderLayout.SOUTH);

            deleteDialog.add(mainPanel);
            deleteDialog.setSize(300,300);
            deleteDialog.setVisible(true);

            yesButton.addActionListener(e1 -> {
                adopterController.deleteUser();
                try {
                    adopterController.saveData();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                System.exit(0);
            });

            noButton.addActionListener(e1 -> {
                deleteDialog.dispose();
            });
        });

        bottomPanel.add(modify);
        bottomPanel.add(deleteButton);

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
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

}
