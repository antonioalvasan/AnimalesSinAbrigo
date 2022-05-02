package org.is2.asa.view.Refuge;

import org.is2.asa.control.RefugeController;
import org.is2.asa.model.Animal;
import org.is2.asa.model.states.AdoptedState;
import org.is2.asa.model.states.AdoptionRequestedState;
import org.is2.asa.model.states.NotAdoptedState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ResquestRefugeSecundaryWindow extends JDialog {
    private RefugeController refugeCtrl;
    public ResquestRefugeSecundaryWindow(RefugeController ctrl){
        this.refugeCtrl=ctrl;

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

        //Panel superior
        JPanel topPanel = new JPanel();

        JLabel topMessage = new JLabel(refugeCtrl.getusername(refugeCtrl.getAnimal().getLinkedUser())+"'s Request ");
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
                refugeCtrl.getAnimal().changeState(new AdoptedState(refugeCtrl.getAnimal()));

                refugeCtrl.changeWindow(RefugeRequestWindow.key);
                refugeCtrl.run();
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
                refugeCtrl.getAnimal().changeState(new NotAdoptedState(refugeCtrl.getAnimal()));
                refugeCtrl.getAnimal().setLinkedUser(refugeCtrl.getID());
                refugeCtrl.changeWindow(RefugeRequestWindow.key);
                refugeCtrl.run();
                ocultar();
            }

        });


        supButton2.setOpaque(true);
        supButton2.setBackground(Color.LIGHT_GRAY);


       Pair namePair = new Pair(new JLabel("Name:"), new JLabel(refugeCtrl.getAnimal().getName()));
        Pair agePair = new Pair(new JLabel("Age:"), new JLabel(String.valueOf(refugeCtrl.getAnimal().getAge())));
        Pair weightPair = new Pair(new JLabel("Weight:"), new JLabel(String.valueOf(refugeCtrl.getAnimal().getWeight())));
        Pair speciePair = new Pair(new JLabel("Specie:"), new JLabel(refugeCtrl.getAnimal().getSpecies()));
       Pair racePair = new Pair(new JLabel("Race:"), new JLabel(refugeCtrl.getAnimal().getRace()));


        ArrayList<Pair> data = new ArrayList<>(Arrays.asList(namePair, agePair, weightPair, speciePair, racePair));
        ArrayList<JPanel> panels = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            panels.add(new JPanel(new FlowLayout()));
            panels.get(i).setBackground(Color.GRAY);
            data.get(i).getFirst().setFont(new Font("Arial", Font.BOLD, 25));
            data.get(i).getSecond().setFont(new Font("Arial", Font.BOLD, 25));
            panels.get(i).add(data.get(i).getFirst());
            panels.get(i).add(data.get(i).getSecond());
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
