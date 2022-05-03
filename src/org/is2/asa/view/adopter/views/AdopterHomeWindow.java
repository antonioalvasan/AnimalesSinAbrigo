package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import java.awt.*;

//MVC design pattern used
public class AdopterHomeWindow extends windowClass {

    public static final String key = "AHW";
    AdopterController adopterController;

    public AdopterHomeWindow(AdopterController adopterController) {
        super(key);
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
        JLabel descriptionLabel = new JLabel("<html>Bienvenido! Somos Animales sin Abrigo, una organización sin ánimo de lucro que se especializa en ponerte <br>" +
                        "en contacto con los mejores refugios de animales para que puedas encontrar a tu mejor amigo (o amigos) de la forma <br>" +
                        "más rápida y amena. Todos nuestros refugios están certificados con el sello de calidad de la Comunidad de Madrid, y cuentan con las mejores<br>" +
                        "instalaciones y trabajadores. <br>" +
                        "<br>" +
                        "¿A qué esperas?<html>");

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
