package org.is2.asa.view.Refuge;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

//MVC design pattern used
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


        RefugeBar bar = new RefugeBar(refugeCtrl);
        bar.prepare_panel();
        this.add(bar, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel change_data_here = new JPanel();
        change_data_here.setLayout(new BoxLayout(change_data_here, BoxLayout.Y_AXIS));

        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel modify = new JLabel("<html><body>Modificar datos<br> <body><html>");
        modify.setFont(new Font("Arial",Font.BOLD,30));
        modify.setHorizontalAlignment(JLabel.CENTER);
        modify.setBackground(Color.LIGHT_GRAY);
        modify.setOpaque(true);
        modify.setBorder(BorderFactory.createLineBorder(Color.black));
        topPanel.add(modify, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e->{
            refugeCtrl.changeWindow(RefugeInfoWindow.key);
            refugeCtrl.run();
        });
        topPanel.add(backButton, BorderLayout.LINE_START);


        JTextField usernameText = new JTextField(refugeCtrl.getUsername());
        usernameText.setColumns(10);
        Pair username = new Pair( new JLabel("Username:"), usernameText);

        JTextField passwordText = new JTextField(refugeCtrl.getPassword());
        passwordText.setColumns(10);
        Pair password = new Pair( new JLabel("Password:"),passwordText);

        JTextField nameText = new JTextField(refugeCtrl.getName());
        nameText.setColumns(10);
        Pair name = new Pair( new JLabel("Name:"),nameText);

        JTextField provinceText = new JTextField(refugeCtrl.getProvince());
        provinceText.setColumns(10);
        Pair province = new Pair( new JLabel("Province:"),provinceText);

        JTextField addressText = new JTextField(refugeCtrl.getAddress());
        addressText.setColumns(10);
        Pair address = new Pair( new JLabel("Address:"),addressText);

        JTextField tlfText = new JTextField(refugeCtrl.getTlf());
        tlfText.setColumns(10);
        Pair tlf = new Pair( new JLabel("Phone number:"),tlfText);

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
                refugeCtrl.changeUserData(
                        username.getTextField().getText(),
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

        centerPanel.add(topPanel, BorderLayout.NORTH);
        centerPanel.add(change_data_here, BorderLayout.CENTER);
        centerPanel.add(save, BorderLayout.SOUTH);

        this.add(centerPanel, BorderLayout.CENTER);
    }
}
