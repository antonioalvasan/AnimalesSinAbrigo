package org.is2.asa.view.Refuge;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class RefugeModifyWindow extends windowClass {

    public final static String key = "RMW";
    private static RefugeController refugeCtrl;

    public RefugeModifyWindow(RefugeController refugeController){
        super(key);
        this.refugeCtrl = refugeController;
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

        Pair username = new Pair( new JLabel("Username:"), new JTextField("Write your new username here..."));
        Pair password = new Pair( new JLabel("Password:"),new JTextField("Write your new password"));
        Pair name = new Pair( new JLabel("Name:"),new JTextField("Write your new name here..."));
        Pair province = new Pair( new JLabel("Province:"), new JTextField("Write your new province here..."));
        Pair address = new Pair( new JLabel("Address:"), new JTextField("Write your new address here..."));
        Pair tlf = new Pair( new JLabel("Phone number:"), new JTextField("Write your new phone number here..."));

        ArrayList<Pair> data = new ArrayList<>(Arrays.asList(username, password, name, province, address, tlf));
        ArrayList<JPanel> panels = new ArrayList<>();

        for(int i =0; i < 6; i++) {
            panels.add(new JPanel(new FlowLayout()));
            panels.get(i).setBackground(Color.GRAY);
            panels.get(i).add(data.get(i).getLabel());
            panels.get(i).add(data.get(i).getTextField());
            change_data_here.add(panels.get(i));
        }

        JButton save = new JButton("Save data");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refugeCtrl.changeUserData(username.getTextField().getText(),
                        password.getTextField().getText(),
                        name.getTextField().getText(),
                        province.getTextField().getText(),
                        address.getTextField().getText(),
                        tlf.getTextField().getText());
                refugeCtrl.changeWindow(RefugeInfoWindow.key);
                refugeCtrl.run();
            }
        });
        save.setOpaque(true);
        save.setBackground(Color.LIGHT_GRAY);

        this.add(modify, BorderLayout.NORTH);
        this.add(change_data_here, BorderLayout.CENTER);
        this.add(save, BorderLayout.SOUTH);

    }
}
