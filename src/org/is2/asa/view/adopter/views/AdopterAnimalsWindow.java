package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.Utilities;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import java.awt.*;

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
        JPanel mainPanel = new JPanel();

        this.add(topPanel, BorderLayout.NORTH);

    }

}
