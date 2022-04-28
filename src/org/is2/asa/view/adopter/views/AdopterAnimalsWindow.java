package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.model.Animal;
import org.is2.asa.view.Utilities;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdopterAnimalsWindow extends windowClass {

    public static final String key = "AAW";
    private AdopterController adopterController;

    public AdopterAnimalsWindow(AdopterController adopterCtrl){
        super(key);
        this.adopterController = adopterCtrl;
    }

    public void prepare_panel(){

        setLayout(new BorderLayout());

        //AdopterBar is the menu Bar.
        AdopterBar adopterBar = new  AdopterBar(this.adopterController);
        adopterBar.prepare_panel();
        this.add(adopterBar, BorderLayout.NORTH);

        //Top Panel -> Includes MenuBar and SearchBar
        JPanel topPanel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.setBackground(Color.LIGHT_GRAY);
        JTextField searchField = new JTextField("Search...");
        searchField.setPreferredSize(new Dimension(300, 20));
        JButton searchButton = new JButton("Search");
        Utilities.setTransparent(searchButton);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        topPanel.add(adopterBar, BorderLayout.NORTH);
        topPanel.add(searchPanel, BorderLayout.SOUTH);

        //Main Panel
        JPanel animalsPanel = new JPanel();
        animalsPanel.setBackground(Color.LIGHT_GRAY);
        animalsPanel.setLayout(new BoxLayout(animalsPanel, BoxLayout.Y_AXIS));

        //adding animal vector
        ArrayList<Animal> animalListAux = (ArrayList<Animal>) adopterController.getAnimalsOwned();
        AdopterAnimalPanel[] animal_vector = new AdopterAnimalPanel[animalListAux.size()];

        for(int i =0; i < animal_vector.length; i++) {
            animal_vector[i] = new AdopterAnimalPanel(animalListAux.get(i), adopterController, "owned");
            animal_vector[i].prepare_panel();
            animalsPanel.add(animal_vector[i]);
        }

        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(500,300));
        scroll.setViewportView(animalsPanel);


        this.add(topPanel, BorderLayout.NORTH);
        this.add(animalsPanel, BorderLayout.CENTER);

    }

}
