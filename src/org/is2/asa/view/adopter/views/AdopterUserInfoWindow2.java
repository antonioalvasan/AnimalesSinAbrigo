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

        JTextField field1= new JTextField();
        field1.setColumns(10);
        field1.setText(adopterController.getUsername());
        Pair username = new Pair( new JLabel("Username:"), field1);

        JTextField field2= new JTextField();
        field2.setColumns(10);
        field2.setText(adopterController.getPassword());
        Pair password = new Pair( new JLabel("Password:"),field2);

        JTextField field6= new JTextField();
        field6.setColumns(10);
        field6.setText(adopterController.getName());
        Pair name = new Pair( new JLabel("Name:"),field6);

        JTextField field3= new JTextField();
        field3.setColumns(10);
        field3.setText(adopterController.getProvince());
        Pair province = new Pair( new JLabel("Province:"),field3);

        JTextField field4= new JTextField();
        field4.setColumns(10);
        field4.setText(adopterController.getUsername());
        Pair address = new Pair( new JLabel("Address:"),field4);

        JTextField field5= new JTextField();
        field5.setColumns(10);
        field5.setText(adopterController.getTlf());
        Pair tlf = new Pair( new JLabel("Phone number:"),field5);
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
