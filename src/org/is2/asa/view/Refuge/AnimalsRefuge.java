package org.is2.asa.view.Refuge;



import org.is2.asa.control.AnimalController;
import org.is2.asa.control.AnimalListController;
import org.is2.asa.control.RefugeController;
import org.is2.asa.model.Animal;
import org.is2.asa.view.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AnimalsRefuge extends JPanel {
    public RefugeController controladorventanas;
    public AnimalListController animalListController;

    public AnimalsRefuge(RefugeController ctrl, AnimalListController animalListController){
        controladorventanas= ctrl;
        this.animalListController = animalListController;
    }

    public void prepare_panel() {
        this.setLayout(new BorderLayout());
        RefugeBar bar = new RefugeBar(controladorventanas);
        bar.prepare_panel();
        this.add(bar, BorderLayout.NORTH);


        JPanel panelcenter= new JPanel();
        panelcenter.setLayout(new BorderLayout());

        JPanel panel_sup1= new JPanel();
        JTextField searchBar = new JTextField("Search...");
        searchBar.setPreferredSize(new Dimension(300, 20));
        JButton search_button = new JButton("Search");
        JButton filters = new JButton("Filters");
        JButton añadir = new JButton("Add animal");
        AddAnimal info= new AddAnimal();
        info.prepare_panel();
        info.setSize(500,400);
        info.setLocationRelativeTo(null);


        añadir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            info.setVisible(true);

            }



        });





        Utilities.setTransparent(search_button);
        Utilities.setTransparent(filters);
        Utilities.setTransparent(añadir);
        JPanel z = new JPanel(new FlowLayout());
        z.setBackground(Color.LIGHT_GRAY);

        z.add(searchBar);
        z.add(search_button);
        z.add(añadir);

        panel_sup1.add(z, BorderLayout.WEST);
        panel_sup1.add(filters, BorderLayout.EAST);

        panel_sup1.setBorder(BorderFactory.createLineBorder(Color.black));

        panel_sup1.setVisible(true);
        panel_sup1.setBackground(Color.LIGHT_GRAY);
        panel_sup1.setBorder(BorderFactory.createLineBorder(Color.black));
        panelcenter.add(panel_sup1,BorderLayout.NORTH);


        JPanel animal_panel = new JPanel();
        animal_panel.setLayout(new BoxLayout(animal_panel, BoxLayout.Y_AXIS));

        //adding animal vector
        List<Animal> animals = animalListController.getAll();
        AnimalPanel[] animalPanels = new AnimalPanel[animals.size()];

        for(int i =0; i < animalPanels.length; i++) {
            AnimalController animalController = new AnimalController(animals.get(i));
            animalPanels[i] = new AnimalPanel(animalController);
            animalPanels[i].prepare_panel(animalController.getName());
            animal_panel.add(animalPanels[i]);

        }

        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(500,300));
        scroll.setViewportView(animal_panel);

        panelcenter.add(scroll,BorderLayout.CENTER);
        panelcenter.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(panelcenter,BorderLayout.CENTER);

    }
}
