package org.is2.asa.view.Refuge;

import org.is2.asa.control.RefugeController;
import org.is2.asa.model.Animal;

import org.is2.asa.view.windowClass;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RefugeAnimalsWindow extends windowClass {

    public final static String key = "RAW";
    public RefugeController refugeCtrl;

    public RefugeAnimalsWindow(RefugeController ctrl){
        super(key);
        refugeCtrl = ctrl;
    }

    public void prepare_panel() {

        this.setLayout(new BorderLayout());

        //REFUGE BAR section
        RefugeBar refugeBar = new RefugeBar(refugeCtrl);
        refugeBar.prepare_panel();
        this.add(refugeBar, BorderLayout.NORTH);

        //Main Panel
        JPanel mainPanel= new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //Search Panel
        JPanel searchPanel= new JPanel();

        JTextField searchTextField = new JTextField("Search...");
        searchTextField.setPreferredSize(new Dimension(300, 20));

        JButton searchButton = new JButton("Search");

        JButton addAnimalButton = new JButton("Add animal");

        addAnimalButton.addActionListener(e->{
            refugeCtrl.changeWindow(RefugeAddAnimalWindow.key);
            refugeCtrl.run();
        });

        JPanel bar = new JPanel(new FlowLayout());
        bar.setBackground(Color.LIGHT_GRAY);
        bar.add(searchTextField);
        bar.add(searchButton);
        bar.add(addAnimalButton);

        searchPanel.add(bar, BorderLayout.WEST);

        searchPanel.setVisible(true);
        searchPanel.setBackground(Color.LIGHT_GRAY);
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        mainPanel.add(searchPanel,BorderLayout.NORTH);

        //REFUGE'S ANIMALS PANEL
        JPanel animalsPanel = new JPanel();
        animalsPanel.setLayout(new BoxLayout(animalsPanel, BoxLayout.Y_AXIS));

        //adding animal vector
        List<Animal> animals = refugeCtrl.getRefugeAnimals();
        RefugeAnimalPanel[] animalPanels = new RefugeAnimalPanel[animals.size()];

        for(int i =0; i < animalPanels.length; i++) {
            animalPanels[i] = new RefugeAnimalPanel(animals.get(i), refugeCtrl);
            animalPanels[i].prepare_panel();
            animalsPanel.add(animalPanels[i]);
        }

        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(500,300));
        scroll.setViewportView(animalsPanel);


        mainPanel.add(scroll, BorderLayout.CENTER);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(mainPanel,BorderLayout.CENTER);

    }
}
