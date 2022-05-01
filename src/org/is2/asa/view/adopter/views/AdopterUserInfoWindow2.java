package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.Refuge.RefugeModifyWindow;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class AdopterUserInfoWindow2 extends windowClass {

    public static final String key = "AUIW2";
    AdopterController adopterController;

    public AdopterUserInfoWindow2(AdopterController adopterController) {
        super(key);
        this.adopterController = adopterController;
    }

    private record Pair(JLabel label, JTextField textField) {

        public JLabel getLabel() {
            return label;
        }

        public JTextField getTextField() {
            return textField;
        }

    }


    public void prepare_panel() {
        this.setLayout(new BorderLayout());

        JPanel change_data_here = new JPanel();
        change_data_here.setLayout(new BoxLayout(change_data_here, BoxLayout.Y_AXIS));

        JLabel modify = new JLabel("<html><body>Modificar datos<br> <body><html>");
        modify.setFont(new Font("Arial",Font.BOLD,30));
        modify.setHorizontalAlignment(JLabel.CENTER);
        modify.setBackground(Color.LIGHT_GRAY);
        modify.setOpaque(true);
        modify.setBorder(BorderFactory.createLineBorder(Color.black));

        JTextField usernameText= new JTextField(adopterController.getUsername());
        usernameText.setColumns(10);
        Pair username = new Pair( new JLabel("Username:"), usernameText);

        JTextField passwordText= new JTextField(adopterController.getPassword());
        passwordText.setColumns(10);
        Pair password = new Pair( new JLabel("Password:"),passwordText);

        JTextField nameText= new JTextField(adopterController.getName());
        nameText.setColumns(10);
        Pair name = new Pair( new JLabel("Name:"),nameText);

        JTextField provinceText= new JTextField(adopterController.getProvince());
        provinceText.setColumns(10);
        Pair province = new Pair( new JLabel("Province:"),provinceText);

        JTextField addressText= new JTextField(adopterController.getUsername());
        addressText.setColumns(10);
        Pair address = new Pair( new JLabel("Address:"),addressText);

        JTextField tlfText= new JTextField(adopterController.getTlf());
        tlfText.setColumns(10);
        Pair tlf = new Pair( new JLabel("Phone number:"),tlfText);

        JButton save = new JButton("Save data");

        ArrayList<Pair> data = new ArrayList<>(Arrays.asList(username, password, name, province, address, tlf));
        ArrayList<JPanel> panels = new ArrayList<>();

        for(int i =0; i < 6; i++) {
            panels.add(new JPanel(new FlowLayout()));
            panels.get(i).setBackground(Color.GRAY);
            panels.get(i).add(data.get(i).getLabel());
            panels.get(i).add(data.get(i).getTextField());
            change_data_here.add(panels.get(i));
        }
        //adding delete user button
        JButton deleteUser = new JButton("Delete User");

        deleteUser.addActionListener(e -> {
            Dialog deleteDialog = new JDialog();
            JPanel buttons = new JPanel(new FlowLayout());
            JButton yesButton = new JButton("Yes");
            JButton noButton = new JButton("No");
            buttons.add(yesButton);
            buttons.add(noButton);
            deleteDialog.add(buttons);
            //deleteDialog.setShape(new Ellipse2D.Double(0,0,300,300));
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

        change_data_here.add(deleteUser);
        //example
        /*
        panels.add(new JPanel(new FlowLayout()));
        panels.get(i).setBackground(Color.GRAY);
        data.get(i).getFirst().setFont(new Font("Arial", Font.BOLD, 25));
        data.get(i).getSecond().setFont(new Font("Arial", Font.BOLD, 25));
        panels.get(i).add(data.get(i).getFirst());
        panels.get(i).add(data.get(i).getSecond());
        leftP.add(panels.get(i));*/
        //

        save.setOpaque(true);
        save.setBackground(Color.LIGHT_GRAY);
        save.addActionListener(e -> {
           adopterController.changeUserData(username.getTextField().getText(),password.getTextField().getText(),
                    name.getTextField().getText(), province.getTextField().getText(), address.getTextField().getText(),
                    tlf.getTextField().getText());
            adopterController.changeWindow(AdopterUserInfoWindow.keyCode);
            adopterController.run();
        });


        this.add(modify, BorderLayout.NORTH);
        this.add(change_data_here, BorderLayout.CENTER);
        this.add(save, BorderLayout.SOUTH);
    }
}
