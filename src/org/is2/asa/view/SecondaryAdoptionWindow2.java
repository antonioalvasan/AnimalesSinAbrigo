package org.is2.asa.view;

import org.is2.asa.control.AdopterController;

import javax.swing.*;
import java.awt.*;

public class SecondaryAdoptionWindow2 extends windowClass {

    public static final String keyCode = "SAW2";
    AdopterController adopterController;

    public SecondaryAdoptionWindow2(AdopterController adopterController) {
        super(keyCode);
        this.adopterController = adopterController;
    }

    public void prepare_panel() {

        this.setLayout(new BorderLayout());

        JLabel message = new JLabel("Tu solicitud ha sido enviada con éxito.");
        message.setFont(new Font("Arial", Font.BOLD, 25));
        message.setHorizontalAlignment(JLabel.CENTER);

        JButton button = new JButton("Volver al refugio");
        button.setHorizontalAlignment(JButton.CENTER);
        button.setBackground(Color.GRAY);
        button.setBorderPainted(false);


        this.add(message, BorderLayout.CENTER);
        this.add(button, BorderLayout.SOUTH);
        this.setBackground(Color.LIGHT_GRAY);

    }
}