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
public class InfoAnimalRefuge extends windowClass {

    public final static String key = "IAR";
    public RefugeController refugeCtrl;

    public InfoAnimalRefuge(RefugeController ctrl) {
        super(key);
        refugeCtrl = ctrl;
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

        RefugeBar bar = new RefugeBar(refugeCtrl);
        bar.prepare_panel();
        this.add(bar, BorderLayout.NORTH);
        JPanel mainPanel = new JPanel(new BorderLayout());


        //Top Panel
        JPanel topPanel = new JPanel();

        JLabel topMessage = new JLabel(refugeCtrl.getAnimal().getName() + "'s data");
        topMessage.setFont(new Font("Arial", Font.BOLD, 30));
        topMessage.setHorizontalAlignment(JLabel.CENTER);

        topPanel.add(topMessage);
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));


        //DELETE POPUP
        JDialog deletePopup = new JDialog(refugeCtrl.viewFrame);

        JPanel deletePanel = new JPanel();
        deletePanel.setLayout(new BorderLayout());

        JLabel deleteMessage = new JLabel(" Animal eliminado");
        deleteMessage.setFont(new Font("Arial", Font.BOLD, 30));
        deleteMessage.setHorizontalAlignment(JLabel.CENTER);

        JButton ok = new JButton("OK");
        ok.setBackground(Color.GRAY);
        ok.addActionListener(e->{
                deletePopup.setVisible(false);
        });

        deletePanel.add(deleteMessage, BorderLayout.CENTER);
        deletePanel.add(ok, BorderLayout.SOUTH);

        deletePopup.add(deletePanel);
        deletePopup.setSize(300, 100);
        deletePopup.setLocationRelativeTo(null);

        //Modify Button
        JButton modifyButton = new JButton("Modify");
        modifyButton.addActionListener(e -> {
            refugeCtrl.changeWindow(ModifyAnimalWindow.key);
            refugeCtrl.run();
        });
        modifyButton.setOpaque(true);
        modifyButton.setBackground(Color.LIGHT_GRAY);

        //Delete Button
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e->{
                refugeCtrl.deleteAnimal(refugeCtrl.getAnimal());
                refugeCtrl.changeWindow(RefugeAnimalsWindow.key);
                refugeCtrl.run();
                deletePopup.setVisible(true);
        });
        deleteButton.setOpaque(true);
        deleteButton.setBackground(Color.LIGHT_GRAY);

        //Info Panel
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.GRAY);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        Pair namePair = new Pair(new JLabel("Name:"), new JLabel(refugeCtrl.getAnimal().getName()));
        Pair agePair = new Pair(new JLabel("Age:"), new JLabel(String.valueOf(refugeCtrl.getAnimal().getAge())+" Years"));
        Pair weightPair = new Pair(new JLabel("Weight:"), new JLabel(String.valueOf(
                refugeCtrl.getAnimal().getWeight()) + " Kg"));
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
            infoPanel.add(panels.get(i));
        }

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(modifyButton);
        bottomPanel.add(deleteButton);
        bottomPanel.setBackground(Color.LIGHT_GRAY);


        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(infoPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        this.add(mainPanel, BorderLayout.CENTER);
    }
}
