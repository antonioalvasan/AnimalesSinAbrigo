package org.is2.asa.view.Refuge;


import org.is2.asa.control.RefugeController;
import org.is2.asa.view.windowClass;
import org.json.JSONPropertyName;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class InfoAnimalRefuge extends windowClass {
    public final static String key = "IAR";
    public RefugeController refugeCtrl;

    private record Pair(JLabel first, JLabel second) {

        public JLabel getFirst() {
            return first;
        }

        public JLabel getSecond() {
            return second;
        }

    }
    public InfoAnimalRefuge(RefugeController ctrl){
        super(key);
        refugeCtrl = ctrl;
    }
    public void prepare_panel() {


            this.setLayout(new BorderLayout());

            RefugeBar bar = new RefugeBar(refugeCtrl);
            bar.prepare_panel();
            this.add(bar,BorderLayout.NORTH);
            JPanel panelcentral= new JPanel(new BorderLayout());



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



            JButton supButton = new JButton("Modify");

         supButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refugeCtrl.changeWindow(ModifyInfoAnimalRefuge.key);
                refugeCtrl.run();
                ;
            }

        });



            supButton.setOpaque(true);
            supButton.setBackground(Color.LIGHT_GRAY);

            JButton supButton2 = new JButton("Delete");


        JDialog dialogo2= new JDialog(refugeCtrl.viewFrame);
        JPanel panel1= new JPanel();
        panel1.setLayout(new BorderLayout());

        JLabel message = new JLabel(" Animal eliminado");
        message.setFont(new Font("Arial", Font.BOLD, 30));
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setBackground(Color.LIGHT_GRAY);
        message.setOpaque(true);
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



        dialogo2.add(panel1);
        dialogo2.setSize(300,100);
        dialogo2.setLocationRelativeTo(null);


        supButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refugeCtrl.removeanimal(refugeCtrl.getAnimal());
                refugeCtrl.changeWindow(RefugeAnimalsWindow.key);
                refugeCtrl.run();
                dialogo2.setVisible(true);

            }

        });
        supButton2.setOpaque(true);
        supButton2.setBackground(Color.LIGHT_GRAY);


        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.GRAY);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        Pair namePair = new Pair( new JLabel("Name:"), new JLabel(refugeCtrl.getAnimal().getName()));
        Pair agePair = new Pair( new JLabel("Age:"), new JLabel(String.valueOf(refugeCtrl.getAnimal().getAge())));
        Pair weightPair = new Pair( new JLabel("Weight:"), new JLabel(String.valueOf(refugeCtrl.getAnimal().getWeight())));
        Pair speciePair = new Pair( new JLabel("Specie:"), new JLabel(refugeCtrl.getAnimal().getSpecies()));
        Pair racePair = new Pair( new JLabel("Race:"), new JLabel(refugeCtrl.getAnimal().getRace()));

        ArrayList<Pair> data = new ArrayList<>(Arrays.asList(namePair, agePair, weightPair, speciePair, racePair));
        ArrayList<JPanel> panels = new ArrayList<>();

        for(int i = 0; i<data.size(); i++){
            panels.add(new JPanel(new FlowLayout()));
            panels.get(i).setBackground(Color.GRAY);
            data.get(i).getFirst().setFont(new Font("Arial", Font.BOLD, 25));
            data.get(i).getSecond().setFont(new Font("Arial", Font.BOLD, 25));
            panels.get(i).add(data.get(i).getFirst());
            panels.get(i).add(data.get(i).getSecond());
            infoPanel.add(panels.get(i));
        }



            supPanel.add(infoPanel);
         JPanel panelbot= new JPanel(new FlowLayout());
         panelbot.add(supButton);
         panelbot.add(supButton2);
        panelbot.setBackground(Color.LIGHT_GRAY);
         supPanel.add(panelbot);

         supPanel.setBackground(Color.LIGHT_GRAY);
         supPanel.setVisible(true);


         panelcentral.add(topPanel,BorderLayout.NORTH);
         panelcentral.add(supPanel,BorderLayout.CENTER);
        this.add(panelcentral,BorderLayout.CENTER);

        }
    private void ocultar() {
        this.setVisible(false);
    }

}
