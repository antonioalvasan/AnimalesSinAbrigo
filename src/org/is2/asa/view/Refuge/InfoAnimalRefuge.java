package org.is2.asa.view.Refuge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class InfoAnimalRefuge extends JPanel {

    public void prepare_panel() {


            this.setLayout(new BorderLayout());

            //Panel superior
            JPanel topPanel = new JPanel();

            JLabel topMessage = new JLabel("Información de Toby");
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

            JButton supButton = new JButton("Modify");
        ModifyInfoAnimalRefuge info= new ModifyInfoAnimalRefuge();
        info.prepare_panel();
        info.setSize(500,300);
        info.setLocationRelativeTo(null);
         supButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                info.setVisible(true);


            }

        });



            supButton.setOpaque(true);
            supButton.setBackground(Color.LIGHT_GRAY);

            JButton supButton2 = new JButton("Delete");


        JDialog dialogo2= new JDialog();
        JPanel panel1= new JPanel();
        panel1.setLayout(new BorderLayout());

        JLabel message = new JLabel(" Animal eliminado");
        panel1.add(message,BorderLayout.CENTER);
        JButton ok= new JButton("OK");
        ok.setBackground(Color.GRAY);
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dialogo2.setVisible(false);
            }

        });

        panel1.add(ok,BorderLayout.SOUTH);
        message.setFont(new Font("Arial", Font.BOLD, 30));
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setBackground(Color.LIGHT_GRAY);
        message.setOpaque(true);


        dialogo2.add(panel1);
        dialogo2.setSize(300,100);
        dialogo2.setLocationRelativeTo(null);


        supButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dialogo2.setVisible(true);

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
        ArrayList<JLabel >data = new ArrayList<>(Arrays.asList(specie, Race, Identifier, LinkedUser, Name,Weight,Description));
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
        this.setVisible(true);

        }


}
