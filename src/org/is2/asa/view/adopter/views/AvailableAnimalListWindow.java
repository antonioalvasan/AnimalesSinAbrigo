package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.model.Animal;
import org.is2.asa.view.Utilities;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AvailableAnimalListWindow extends windowClass {

    public final static String key = "AAL";
    public AdopterController adopterController;

    public AvailableAnimalListWindow(AdopterController adopterController) {
        super(key);
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

        // top panel

        AdopterBar aB = new AdopterBar(adopterController);
        aB.prepare_panel();

        // bottom panel

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

        //Upper panel mods
        panel_sup1.add(z, BorderLayout.WEST);
        panel_sup1.add(filters, BorderLayout.EAST);

        JLabel refugeName = new JLabel("REFUGIO: " + adopterController.getCurrentRefuge().getName());
        refugeName.setFont(new Font("Arial", Font.BOLD, 30));

        panel_sup1.add(refugeName, BorderLayout.CENTER);

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
        ArrayList<Animal> animalListAux = (ArrayList<Animal>) adopterController.getAnimalsFromRefuge();
        AnimalPanel[] animal_vector = new AnimalPanel[animalListAux.size()];

        for(int i =0; i < animal_vector.length; i++) {
            animal_vector[i] = new AnimalPanel(animalListAux.get(i), adopterController);
            animal_vector[i].prepare_panel();
            animal_panel.add(animal_vector[i]);
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
