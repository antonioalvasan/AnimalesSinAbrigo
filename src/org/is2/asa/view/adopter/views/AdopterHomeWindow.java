package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import java.awt.*;

public class AdopterHomeWindow extends windowClass {

    public static final String keyCode = "AHW";
    AdopterController adopterController;

    public AdopterHomeWindow(AdopterController adopterController) {
        super(keyCode);
        this.adopterController = adopterController;
    }

    public void prepare_panel() {

        setLayout(new BorderLayout());

        //AdopterBar is the menu Bar.
        AdopterBar adopterBar = new  AdopterBar(this.adopterController);
        adopterBar.prepare_panel();
        this.add(adopterBar, BorderLayout.NORTH);

        //Main Panel contains every welcome and description panel.
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel(new BorderLayout());
        JPanel welcomePanel = new JPanel(new BorderLayout());

        //Title Panel
        titlePanel.setBackground(Color.gray);
        titlePanel.setBorder(BorderFactory.createLineBorder(Color.black));


        JLabel title = new JLabel("Animales Sin Abrigo");
        title.setFont(new Font("Arial",Font.BOLD,75));
        title.setHorizontalAlignment(JLabel.CENTER);

        titlePanel.add(title, BorderLayout.CENTER);



        //Welcome Panel
        welcomePanel.setBackground(Color.LIGHT_GRAY);

        JLabel welcomeLabel = new JLabel("<html><body><br>Welcome," + adopterController.getName() + "<body><html>");
        JLabel descriptionLabel = new JLabel("<html><body>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
                "<br>ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                "<br>ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat" +
                "<br>nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim " +
                "<br>id est laborum.<body><html>");

        welcomeLabel.setFont(new Font("Arial",Font.BOLD,35));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);

        welcomePanel.add(welcomeLabel, BorderLayout.NORTH);
        welcomePanel.add(descriptionLabel, BorderLayout.CENTER);


        mainPanel.add(titlePanel, BorderLayout.CENTER);
        mainPanel.add(welcomePanel, BorderLayout.SOUTH);

        this.add(mainPanel, BorderLayout.CENTER);

    }
}
