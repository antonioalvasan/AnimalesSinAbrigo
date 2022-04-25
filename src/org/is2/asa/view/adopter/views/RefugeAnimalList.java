package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.control.AnimalListController;
import org.is2.asa.model.Animal;
import org.is2.asa.model.User;
import org.is2.asa.view.Utilities;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RefugeAnimalList extends windowClass {

    public static final String key = "RAL";
    User refuge;
    AnimalListController animalListController;
    AdopterController adopterController;

    public RefugeAnimalList(AdopterController adopterController) {
        super(key);
        this.refuge = adopterController.getCurrentRefuge();
        this.animalListController = adopterController.getAnimalList();
        this.adopterController = adopterController;
    }

    public void prepare_panel() {
        // Panel declaration
        this.setLayout(new BorderLayout());
        JPanel panel_sup = new JPanel((new BorderLayout()));
        panel_sup.setBackground(Color.LIGHT_GRAY);


        /********* Superior section **********/

        JPanel panel_sup0 = new JPanel(new BorderLayout());
        JPanel panel_sup1 = new JPanel(new BorderLayout());
        panel_sup0.setBackground(Color.LIGHT_GRAY);
        panel_sup1.setBackground(Color.LIGHT_GRAY);

        // superior panel

        AdopterBar aB = new AdopterBar(adopterController);
        aB.prepare_panel();

        // Inferior panel

        JTextField searchBar = new JTextField("Search...");
        searchBar.setPreferredSize(new Dimension(300, 20));
        JButton search_button = new JButton("Search");
        JButton filters = new JButton("Filters");

        Utilities.setTransparent(search_button);
        Utilities.setTransparent(filters);

        JPanel z = new JPanel(new FlowLayout());
        z.setBackground(Color.LIGHT_GRAY);
        z.add(searchBar);
        z.add(search_button);

        panel_sup1.add(z, BorderLayout.WEST);
        panel_sup1.add(filters, BorderLayout.EAST);

        panel_sup1.setBorder(BorderFactory.createLineBorder(Color.black));

        panel_sup1.setVisible(true);

        // adding panels
        panel_sup.add(aB, BorderLayout.NORTH);
        panel_sup.add(panel_sup1, BorderLayout.SOUTH);

        panel_sup.setVisible(true);

        /********* End of superior section ***********/

        /********** Inferior section ***********/

        JPanel animal_panel = new JPanel();
        animal_panel.setLayout(new BoxLayout(animal_panel, BoxLayout.Y_AXIS));

        //adding animal vector
        ArrayList<Animal> animalList = (ArrayList<Animal>) animalListController.getAll();
        ArrayList<AnimalPanel> animal_panels = new ArrayList<>();

        for(int i =0; i < animalList.size(); i++) {
            animal_panels.add(new AnimalPanel(animalList.get(i)));
            animal_panels.get(i).prepare_panel();
        }

        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(500,300));
        scroll.setViewportView(animal_panel);


        /********** End of inferior section *********/

        // Adding both panels to main one

        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(panel_sup, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
    }

}