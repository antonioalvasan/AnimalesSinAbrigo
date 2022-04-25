package org.is2.asa.view.Refuge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ResquestRefugeSecundaryWindow extends JDialog {
    public void prepare_panel() {


        this.setLayout(new BorderLayout());

        //Panel superior
        JPanel topPanel = new JPanel();

        JLabel topMessage = new JLabel("Request Data");
        topMessage.setFont(new Font("Arial", Font.BOLD, 30));
        topMessage.setHorizontalAlignment(JLabel.CENTER);
        topMessage.setBackground(Color.LIGHT_GRAY);
        topMessage.setOpaque(true);


        topPanel.add(topMessage);
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        topPanel.setVisible(true);


        //Panel inferior
        JPanel supPanel = new JPanel();
        supPanel.setLayout(new BoxLayout(supPanel, BoxLayout.Y_AXIS));
        JPanel datos = new JPanel();
        datos.setLayout(new BoxLayout(datos, BoxLayout.Y_AXIS));

        JButton supButton = new JButton("Accept");

        supButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ocultar();
            }

        });




        supButton.setOpaque(true);
        supButton.setBackground(Color.LIGHT_GRAY);

        JButton supButton2 = new JButton("Deny");


        supButton2.setBackground(Color.GRAY);
        supButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ocultar();
            }

        });


        supButton2.setOpaque(true);
        supButton2.setBackground(Color.LIGHT_GRAY);


        JLabel specie = new JLabel("Specie: Dog");
        JLabel Race = new JLabel("Race: Golden Retriever");
        JLabel Identifier = new JLabel("Identifier: 1");
        JLabel LinkedUser = new JLabel("LinkedUser: null");
        JLabel Name = new JLabel("Name: Toby");
        JLabel Age = new JLabel("Age: 10");
        JLabel Weight = new JLabel("Weight: 80.03");
        JLabel Description = new JLabel("Description: Soy bueno :)");
        ArrayList<JLabel > data = new ArrayList<>(Arrays.asList(specie, Race, Identifier, LinkedUser, Name,Weight,Description));
        ArrayList<JPanel> panels = new ArrayList<>();

        for(int i =0; i < 6; i++) {
            panels.add(new JPanel(new FlowLayout()));
            panels.get(i).setBackground(Color.GRAY);
            panels.get(i).add(data.get(i));
            panels.get(i).add(data.get(i));
            datos.add(panels.get(i));
        }



        supPanel.add(datos);
        JPanel panelbot= new JPanel(new FlowLayout());
        panelbot.add(supButton);
        panelbot.add(supButton2);
        panelbot.setBackground(Color.LIGHT_GRAY);
        supPanel.add(panelbot);

        supPanel.setBackground(Color.LIGHT_GRAY);
        supPanel.setVisible(true);


        this.add(topPanel,BorderLayout.NORTH);
        this.add(supPanel,BorderLayout.CENTER);


    }
    private void ocultar() {
        this.setVisible(false);
    }

}
